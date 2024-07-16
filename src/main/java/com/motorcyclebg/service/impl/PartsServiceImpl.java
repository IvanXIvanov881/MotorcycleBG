package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.*;
import com.motorcyclebg.model.entity.EquipmentEntity;
import com.motorcyclebg.model.entity.PartsEntity;
import com.motorcyclebg.repository.EquipmentRepository;
import com.motorcyclebg.repository.PartsRepository;
import com.motorcyclebg.service.ExRateService;
import com.motorcyclebg.service.PartsService;
import com.motorcyclebg.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsServiceImpl implements PartsService {

    private final PartsRepository partsRepository;
    private static ExRateService exRateService;


    public PartsServiceImpl(PartsRepository partsRepository,
                                ExRateService exRateService) {
        this.partsRepository = partsRepository;
        this.exRateService = exRateService;
    }

    @Override
    public long createParts(AddPartsDTO addPartsDTO) {
        return partsRepository.save(map(addPartsDTO)).getId();
    }

    @Override
    public PartsDetailsDTO getPartsDetails(Long id) {
        return this.partsRepository
                .findById(id)
                .map(this::toPartsDetails)
                .orElseThrow(() -> new ObjectNotFoundException("Exception with ID: ", id));
    }

    @Override
    public void deleteParts(long partsId) {
        partsRepository.deleteById(partsId);
    }

    @Override
    public List<PartsSummaryDTO> getAllPartsSummary() {
        return partsRepository
                .findAll()
                .stream()
                .map(PartsServiceImpl::toPartsSummary)
                .toList();
    }

    private static PartsSummaryDTO toPartsSummary(PartsEntity partsEntity){
        //TODO use mapping library
        return new PartsSummaryDTO(partsEntity.getId(),
                partsEntity.getPartsType(),
                partsEntity.getPartsBrand(),
                partsEntity.getPartsPrice(),
                exRateService.allSupportedCurrencies()
        );
    }

    private PartsDetailsDTO toPartsDetails(PartsEntity partsEntity){
        //TODO use mapping library
        return new PartsDetailsDTO(
                partsEntity.getId(),
                partsEntity.getPartsType(),
                partsEntity.getPartsBrand(),
                partsEntity.getPartsConditionType(),
                partsEntity.getPartsDescription(),
                partsEntity.getPartsPrice(),
                exRateService.allSupportedCurrencies(),
                partsEntity.getImages()
        );
    }

    private static PartsEntity map(AddPartsDTO addPartsDTO) {

        //TODO: we have to use ModelMapper
        return new PartsEntity()
                .setPartsType(addPartsDTO.getPartsType())
                .setPartsBrand(addPartsDTO.getPartsBrand())
                .setPartsConditionType(addPartsDTO.getPartsConditionType())
                .setPartsDescription(addPartsDTO.getPartsDescription())
                .setPartsPrice(addPartsDTO.getPartsPrice())
                .setImages(addPartsDTO.getImages());
    }
}
