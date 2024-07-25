package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.AddEquipmentDTO;
import com.motorcyclebg.model.dto.EquipmentDetailsDTO;
import com.motorcyclebg.model.dto.EquipmentSummaryDTO;
import com.motorcyclebg.model.entity.EquipmentEntity;
import com.motorcyclebg.model.enums.EquipmentTypeEnum;
import com.motorcyclebg.repository.EquipmentRepository;
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
class EquipmentServiceImplTest {

    @Mock
    private EquipmentRepository equipmentRepository;

    @Mock
    private ExRateService exRateService;

    @InjectMocks
    private EquipmentServiceImpl equipmentService;

    private EquipmentEntity equipmentEntity;
    private AddEquipmentDTO addEquipmentDTO;

    @BeforeEach
    void setUp() {
        equipmentEntity = new EquipmentEntity();
        equipmentEntity.setId(1L);
        equipmentEntity.setEquipmentType(EquipmentTypeEnum.Helmets);
        equipmentEntity.setEquipmentBrand("AGV");
        equipmentEntity.setCity("Sofia");
        equipmentEntity.setEquipmentPrice(250);

        addEquipmentDTO = new AddEquipmentDTO();
        addEquipmentDTO.setEquipmentType(EquipmentTypeEnum.Helmets);
        addEquipmentDTO.setEquipmentBrand("AGV");
        addEquipmentDTO.setCity("Sofia");
        addEquipmentDTO.setEquipmentPrice(250);
    }

    @Test
    void createEquipment_ShouldReturnEquipmentId() {
        when(equipmentRepository.save(any(EquipmentEntity.class))).thenReturn(equipmentEntity);

        long equipmentId = equipmentService.createEquipment(addEquipmentDTO);

        Assertions.assertEquals(1L, equipmentId);
        verify(equipmentRepository, times(1)).save(any(EquipmentEntity.class));
    }

    @Test
    void getEquipmentDetails_ShouldReturnEquipmentDetails() {
        when(equipmentRepository.findById(1L)).thenReturn(Optional.of(equipmentEntity));
        when(exRateService.allSupportedCurrencies()).thenReturn(List.of("USD", "EUR"));

        EquipmentDetailsDTO equipmentDetails = equipmentService.getEquipmentDetails(1L);

        Assertions.assertNotNull(equipmentDetails);
        Assertions.assertEquals(1L, equipmentDetails.id());
        Assertions.assertEquals(EquipmentTypeEnum.Helmets, equipmentDetails.equipmentType());
        Assertions.assertEquals("AGV", equipmentDetails.equipmentBrand());
        Assertions.assertEquals("Sofia", equipmentDetails.city());
        Assertions.assertEquals(250, equipmentDetails.equipmentPrice());
        Assertions.assertEquals(List.of("USD", "EUR"), equipmentDetails.allCurrencies());

        verify(equipmentRepository, times(1)).findById(1L);
        verify(exRateService, times(1)).allSupportedCurrencies();
    }

    @Test
    void getEquipmentDetails_ShouldThrowException_WhenEquipmentNotFound() {
        when(equipmentRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ObjectNotFoundException.class, () -> equipmentService.getEquipmentDetails(1L));

        verify(equipmentRepository, times(1)).findById(1L);
    }

    @Test
    void deleteEquipment_ShouldDeleteEquipment() {
        doNothing().when(equipmentRepository).deleteById(1L);

        equipmentService.deleteEquipment(1L);

        verify(equipmentRepository, times(1)).deleteById(1L);
    }

    @Test
    void getAllEquipmentSummary_ShouldReturnListOfEquipmentSummary() {
        when(equipmentRepository.findAll()).thenReturn(List.of(equipmentEntity));
        when(exRateService.allSupportedCurrencies()).thenReturn(List.of("USD", "EUR"));

        List<EquipmentSummaryDTO> equipmentSummaries = equipmentService.getAllEquipmentSummary();

        Assertions.assertNotNull(equipmentSummaries);
        Assertions.assertEquals(1, equipmentSummaries.size());
        Assertions.assertEquals(1L, equipmentSummaries.get(0).id());
        Assertions.assertEquals(EquipmentTypeEnum.Helmets, equipmentSummaries.get(0).equipmentType());
        Assertions.assertEquals("AGV", equipmentSummaries.get(0).equipmentBrand());
        Assertions.assertEquals("Sofia", equipmentSummaries.get(0).city());
        Assertions.assertEquals(250, equipmentSummaries.get(0).equipmentPrice());
        Assertions.assertEquals(List.of("USD", "EUR"), equipmentSummaries.get(0).allCurrencies());

        verify(equipmentRepository, times(1)).findAll();
        verify(exRateService, times(1)).allSupportedCurrencies();
    }
}