package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.AddEquipmentDTO;
import com.motorcyclebg.model.dto.EquipmentDetailsDTO;
import com.motorcyclebg.model.dto.EquipmentSummaryDTO;
import com.motorcyclebg.model.entity.EquipmentEntity;
import com.motorcyclebg.repository.EquipmentRepository;
import com.motorcyclebg.service.EquipmentService;
import com.motorcyclebg.service.ExRateService;
import com.motorcyclebg.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private static ExRateService exRateService;


    public EquipmentServiceImpl(EquipmentRepository equipmentRepository,
                                ExRateService exRateService) {
        this.equipmentRepository = equipmentRepository;
        this.exRateService = exRateService;
    }

    @Override
    public long createEquipment(AddEquipmentDTO addEquipmentDTO) {
        return equipmentRepository.save(map(addEquipmentDTO)).getId();
    }

    @Override
    public EquipmentDetailsDTO getEquipmentDetails(Long id) {
        return this.equipmentRepository
                .findById(id)
                .map(this::toEquipmentDetails)
                .orElseThrow(() -> new ObjectNotFoundException("Exception with ID: ", id));
    }

    @Override
    public void deleteEquipment(long equipmentId) {
        equipmentRepository.deleteById(equipmentId);
    }

    @Override
    public List<EquipmentSummaryDTO> getAllEquipmentSummary() {
        return equipmentRepository
                .findAll()
                .stream()
                .map(EquipmentServiceImpl::toEquipmentSummary)
                .toList();
    }

    private static EquipmentSummaryDTO toEquipmentSummary(EquipmentEntity equipmentEntity){
        //TODO use mapping library
        return new EquipmentSummaryDTO(equipmentEntity.getId(),
                equipmentEntity.getEquipmentType(),
                equipmentEntity.getEquipmentBrand(),
                equipmentEntity.getCity(),
                equipmentEntity.getEquipmentPrice(),
                equipmentEntity.getImages(),
                exRateService.allSupportedCurrencies()
        );
    }

    private EquipmentDetailsDTO toEquipmentDetails(EquipmentEntity equipmentEntity){
        //TODO use mapping library
        return new EquipmentDetailsDTO(
                equipmentEntity.getId(),
                equipmentEntity.getEquipmentType(),
                equipmentEntity.getEquipmentBrand(),
                equipmentEntity.getEquipmentConditionType(),
                equipmentEntity.getEquipmentDescription(),
                equipmentEntity.getPhone(),
                equipmentEntity.getCity(),
                equipmentEntity.getEquipmentPrice(),
                exRateService.allSupportedCurrencies(),
                equipmentEntity.getImages()
        );
    }

    private static EquipmentEntity map(AddEquipmentDTO addEquipmentDTO) {

        //TODO: we have to use ModelMapper
        return new EquipmentEntity()
                .setEquipmentType(addEquipmentDTO.getEquipmentType())
                .setEquipmentBrand(addEquipmentDTO.getEquipmentBrand())
                .setEquipmentConditionType(addEquipmentDTO.getEquipmentConditionType())
                .setEquipmentDescription(addEquipmentDTO.getEquipmentDescription())
                .setPhone(addEquipmentDTO.getPhone())
                .setCity(addEquipmentDTO.getCity())
                .setEquipmentPrice(addEquipmentDTO.getEquipmentPrice())
                .setImages(addEquipmentDTO.getImages());
    }
}
