package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.HomeSummaryDTO;
import com.motorcyclebg.model.entity.EquipmentEntity;
import com.motorcyclebg.model.entity.OfferEntity;
import com.motorcyclebg.model.entity.PartsEntity;
import com.motorcyclebg.repository.EquipmentRepository;
import com.motorcyclebg.repository.OfferRepository;
import com.motorcyclebg.repository.PartsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HomeServiceImplTest {

    @Mock
    private OfferRepository offerRepository;

    @Mock
    private EquipmentRepository equipmentRepository;

    @Mock
    private PartsRepository partsRepository;

    @InjectMocks
    private HomeServiceImpl homeService;

    private OfferEntity offerEntity;
    private EquipmentEntity equipmentEntity;
    private PartsEntity partsEntity;

    @BeforeEach
    void setUp() {
        offerEntity = new OfferEntity();
        offerEntity.setPhone(123456789);
        offerEntity.setCity("Sofia");
        offerEntity.setImages(List.of("image1.jpg", "image2.jpg"));

        equipmentEntity = new EquipmentEntity();
        equipmentEntity.setPhone(987654321);
        equipmentEntity.setCity("Plovdiv");
        equipmentEntity.setImages(List.of("image3.jpg", "image4.jpg"));

        partsEntity = new PartsEntity();
        partsEntity.setPhone(555555555);
        partsEntity.setCity("Varna");
        partsEntity.setImages(List.of("image5.jpg", "image6.jpg"));
    }

    @Test
    void getAllLastSummaries_ShouldReturnShuffledList() {
        when(offerRepository.findAll()).thenReturn(List.of(offerEntity));
        when(equipmentRepository.findAll()).thenReturn(List.of(equipmentEntity));
        when(partsRepository.findAll()).thenReturn(List.of(partsEntity));

        List<HomeSummaryDTO> summaries = homeService.getAllLastSummaries();

        Assertions.assertNotNull(summaries);
        Assertions.assertEquals(3, summaries.size());
        verify(offerRepository, times(1)).findAll();
        verify(equipmentRepository, times(1)).findAll();
        verify(partsRepository, times(1)).findAll();
    }

    @Test
    void offersToHomeSummaryDTO_ShouldReturnHomeSummaryDTO() {
        HomeSummaryDTO dto = HomeServiceImpl.offersToHomeSummaryDTO(offerEntity);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(123456789, dto.phone());
        Assertions.assertEquals("Sofia", dto.city());
        Assertions.assertEquals(List.of("image1.jpg", "image2.jpg"), dto.images());
    }

    @Test
    void equipmentToHomeSummaryDTO_ShouldReturnHomeSummaryDTO() {
        HomeSummaryDTO dto = HomeServiceImpl.equipmentToHomeSummaryDTO(equipmentEntity);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(987654321, dto.phone());
        Assertions.assertEquals("Plovdiv", dto.city());
        Assertions.assertEquals(List.of("image3.jpg", "image4.jpg"), dto.images());
    }

    @Test
    void partsToHomeSummaryDTO_ShouldReturnHomeSummaryDTO() {
        HomeSummaryDTO dto = HomeServiceImpl.partsToHomeSummaryDTO(partsEntity);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(555555555, dto.phone());
        Assertions.assertEquals("Varna", dto.city());
        Assertions.assertEquals(List.of("image5.jpg", "image6.jpg"), dto.images());
    }
}
