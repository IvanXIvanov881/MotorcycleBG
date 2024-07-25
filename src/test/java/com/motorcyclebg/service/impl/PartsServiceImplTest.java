package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.AddPartsDTO;
import com.motorcyclebg.model.dto.PartsDetailsDTO;
import com.motorcyclebg.model.dto.PartsSummaryDTO;
import com.motorcyclebg.model.entity.PartsEntity;
import com.motorcyclebg.model.enums.PartsTypeEnum;
import com.motorcyclebg.repository.PartsRepository;
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
class PartsServiceImplTest {

    @Mock
    private PartsRepository partsRepository;

    @Mock
    private ExRateService exRateService;

    @InjectMocks
    private PartsServiceImpl partsService;

    private PartsEntity partsEntity;
    private AddPartsDTO addPartsDTO;

    @BeforeEach
    void setUp() {
        partsEntity = new PartsEntity();
        partsEntity.setId(1L);
        partsEntity.setPartsType(PartsTypeEnum.MotorcycleBrakes);
        partsEntity.setPartsBrand("Brembo");
        partsEntity.setCity("Sofia");
        partsEntity.setPartsPrice(50);

        addPartsDTO = new AddPartsDTO();
        addPartsDTO.setPartsType(PartsTypeEnum.MotorcycleBrakes);
        addPartsDTO.setPartsBrand("Brembo");
        addPartsDTO.setCity("Sofia");
        addPartsDTO.setPartsPrice(50);
    }

    @Test
    void createParts_ShouldReturnPartsId() {
        when(partsRepository.save(any(PartsEntity.class))).thenReturn(partsEntity);

        long partsId = partsService.createParts(addPartsDTO);

        Assertions.assertEquals(1L, partsId);
        verify(partsRepository, times(1)).save(any(PartsEntity.class));
    }

    @Test
    void getPartsDetails_ShouldReturnPartsDetails() {
        when(partsRepository.findById(1L)).thenReturn(Optional.of(partsEntity));
        when(exRateService.allSupportedCurrencies()).thenReturn(List.of("USD", "EUR"));

        PartsDetailsDTO partsDetails = partsService.getPartsDetails(1L);

        Assertions.assertNotNull(partsDetails);
        Assertions.assertEquals(1L, partsDetails.id());
        Assertions.assertEquals(PartsTypeEnum.MotorcycleBrakes, partsDetails.partsType());
        Assertions.assertEquals("Brembo", partsDetails.partsBrand());
        Assertions.assertEquals("Sofia", partsDetails.city());
        Assertions.assertEquals(50, partsDetails.partsPrice());
        Assertions.assertEquals(List.of("USD", "EUR"), partsDetails.allCurrencies());

        verify(partsRepository, times(1)).findById(1L);
        verify(exRateService, times(1)).allSupportedCurrencies();
    }

    @Test
    void getPartsDetails_ShouldThrowException_WhenPartsNotFound() {
        when(partsRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ObjectNotFoundException.class, () -> partsService.getPartsDetails(1L));

        verify(partsRepository, times(1)).findById(1L);
    }

    @Test
    void deleteParts_ShouldDeleteParts() {
        doNothing().when(partsRepository).deleteById(1L);

        partsService.deleteParts(1L);

        verify(partsRepository, times(1)).deleteById(1L);
    }

    @Test
    void getAllPartsSummary_ShouldReturnListOfPartsSummary() {
        when(partsRepository.findAll()).thenReturn(List.of(partsEntity));
        when(exRateService.allSupportedCurrencies()).thenReturn(List.of("USD", "EUR"));

        List<PartsSummaryDTO> partsSummaries = partsService.getAllPartsSummary();

        Assertions.assertNotNull(partsSummaries);
        Assertions.assertEquals(1, partsSummaries.size());
        Assertions.assertEquals(1L, partsSummaries.get(0).id());
        Assertions.assertEquals(PartsTypeEnum.MotorcycleBrakes, partsSummaries.get(0).partsType());
        Assertions.assertEquals("Brembo", partsSummaries.get(0).partsBrand());
        Assertions.assertEquals("Sofia", partsSummaries.get(0).city());
        Assertions.assertEquals(50, partsSummaries.get(0).partsPrice());
        Assertions.assertEquals(List.of("USD", "EUR"), partsSummaries.get(0).allCurrencies());

        verify(partsRepository, times(1)).findAll();
        verify(exRateService, times(1)).allSupportedCurrencies();
    }
}
