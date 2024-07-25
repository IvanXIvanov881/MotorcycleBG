package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.AddOfferDTO;
import com.motorcyclebg.model.dto.OfferDetailsDTO;
import com.motorcyclebg.model.dto.OfferSummaryDTO;
import com.motorcyclebg.model.entity.OfferEntity;
import com.motorcyclebg.model.enums.BrandTypeEnum;
import com.motorcyclebg.repository.OfferRepository;
import com.motorcyclebg.service.ExRateService;
import com.motorcyclebg.service.exception.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OfferServiceImplTest {

    @Mock
    private OfferRepository offerRepository;

    @Mock
    private ExRateService exRateService;

    @InjectMocks
    private OfferServiceImpl offerService;

    private OfferEntity offerEntity;
    private AddOfferDTO addOfferDTO;

    @BeforeEach
    void setUp() {
        offerEntity = new OfferEntity();
        offerEntity.setId(1L);
        offerEntity.setBrand(BrandTypeEnum.HONDA);
        offerEntity.setModel("CBR600RR");
        offerEntity.setMileage(10000);
        offerEntity.setYear(2020);
        offerEntity.setCubicCentimeters(599);
        offerEntity.setCity("Sofia");
        offerEntity.setPrice(12000);

        addOfferDTO = new AddOfferDTO();
        addOfferDTO.setBrandType(BrandTypeEnum.HONDA);
        addOfferDTO.setModel("CBR600RR");
        addOfferDTO.setMileage(10000);
        addOfferDTO.setYear(2020);
        addOfferDTO.setCubicCentimeters(599);
        addOfferDTO.setCity("Sofia");
        addOfferDTO.setPrice(12000);
    }

    @Test
    void createOffer_ShouldReturnOfferId() {
        when(offerRepository.save(any(OfferEntity.class))).thenReturn(offerEntity);

        long offerId = offerService.createOffer(addOfferDTO);

        Assertions.assertEquals(1L, offerId);
        verify(offerRepository, times(1)).save(any(OfferEntity.class));
    }

    @Test
    void getOfferDetails_ShouldReturnOfferDetails() {
        when(offerRepository.findById(1L)).thenReturn(Optional.of(offerEntity));
        when(exRateService.allSupportedCurrencies()).thenReturn(List.of("USD", "EUR"));

        OfferDetailsDTO offerDetails = offerService.getOfferDetails(1L);

        Assertions.assertNotNull(offerDetails);
        Assertions.assertEquals(1L, offerDetails.id());
        Assertions.assertEquals(BrandTypeEnum.HONDA, offerDetails.brandType());
        Assertions.assertEquals("CBR600RR", offerDetails.model());
        Assertions.assertEquals(10000, offerDetails.mileage());
        Assertions.assertEquals(2020, offerDetails.year());
        Assertions.assertEquals(599, offerDetails.cubicCentimeters());
        Assertions.assertEquals("Sofia", offerDetails.city());
        Assertions.assertEquals(12000, offerDetails.price());
        Assertions.assertEquals(List.of("USD", "EUR"), offerDetails.allCurrencies());

        verify(offerRepository, times(1)).findById(1L);
        verify(exRateService, times(1)).allSupportedCurrencies();
    }

    @Test
    void getOfferDetails_ShouldThrowException_WhenOfferNotFound() {
        when(offerRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ObjectNotFoundException.class, () -> offerService.getOfferDetails(1L));

        verify(offerRepository, times(1)).findById(1L);
    }

    @Test
    void deleteOffer_ShouldDeleteOffer() {
        doNothing().when(offerRepository).deleteById(1L);

        offerService.deleteOffer(1L);

        verify(offerRepository, times(1)).deleteById(1L);
    }

    @Test
    void getAllOffersSummary_ShouldReturnListOfOfferSummary() {
        when(offerRepository.findAll()).thenReturn(List.of(offerEntity));
        when(exRateService.allSupportedCurrencies()).thenReturn(List.of("USD", "EUR"));

        List<OfferSummaryDTO> offerSummaries = offerService.getAllOffersSummary();

        Assertions.assertNotNull(offerSummaries);
        Assertions.assertEquals(1, offerSummaries.size());
        Assertions.assertEquals(1L, offerSummaries.get(0).id());
        Assertions.assertEquals(BrandTypeEnum.HONDA, offerSummaries.get(0).brandType());
        Assertions.assertEquals("CBR600RR", offerSummaries.get(0).model());
        Assertions.assertEquals(10000, offerSummaries.get(0).mileage());
        Assertions.assertEquals(2020, offerSummaries.get(0).year());
        Assertions.assertEquals(599, offerSummaries.get(0).cubicCentimeters());
        Assertions.assertEquals("Sofia", offerSummaries.get(0).city());
        Assertions.assertEquals(12000, offerSummaries.get(0).price());
        Assertions.assertEquals(List.of("USD", "EUR"), offerSummaries.get(0).allCurrencies());

        verify(offerRepository, times(1)).findAll();
        verify(exRateService, times(1)).allSupportedCurrencies();
    }
}
