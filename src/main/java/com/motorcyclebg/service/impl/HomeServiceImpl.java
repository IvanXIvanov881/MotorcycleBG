package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.HomeSummaryDTO;
import com.motorcyclebg.model.entity.EquipmentEntity;
import com.motorcyclebg.model.entity.OfferEntity;
import com.motorcyclebg.model.entity.PartsEntity;
import com.motorcyclebg.repository.EquipmentRepository;
import com.motorcyclebg.repository.OfferRepository;
import com.motorcyclebg.repository.PartsRepository;
import com.motorcyclebg.service.HomeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    private final OfferRepository offerRepository;
    private final EquipmentRepository equipmentRepository;
    private final PartsRepository partsRepository;

    public HomeServiceImpl(OfferRepository offerRepository, EquipmentRepository equipmentRepository, PartsRepository partsRepository) {
        this.offerRepository = offerRepository;
        this.equipmentRepository = equipmentRepository;
        this.partsRepository = partsRepository;
    }

    @Override
    public List<HomeSummaryDTO> getAllLastSummaries() {


        List<HomeSummaryDTO> homeList = new ArrayList<>();

        homeList.addAll(offerRepository
                .findAll()
                .stream()
                .map(HomeServiceImpl::offersToHomeSummaryDTO)
                .toList());

        homeList.addAll(equipmentRepository
                .findAll()
                .stream()
                .map(HomeServiceImpl::equipmentToHomeSummaryDTO)
                .toList());

        homeList.addAll(partsRepository
                .findAll()
                .stream()
                .map(HomeServiceImpl::partsToHomeSummaryDTO)
                .toList());

        Collections.shuffle(homeList);
        return homeList;
    }

    private static HomeSummaryDTO offersToHomeSummaryDTO(OfferEntity offerEntity) {
        //TODO use mapping library
        return new HomeSummaryDTO(

                offerEntity.getPhone(),
                offerEntity.getCity(),
                offerEntity.getImages()

        );
    }

    private static HomeSummaryDTO equipmentToHomeSummaryDTO(EquipmentEntity equipmentEntity) {
        //TODO use mapping library
        return new HomeSummaryDTO(

                equipmentEntity.getPhone(),
                equipmentEntity.getCity(),
                equipmentEntity.getImages()

        );
    }

    private static HomeSummaryDTO partsToHomeSummaryDTO(PartsEntity partsEntity) {
        //TODO use mapping library
        return new HomeSummaryDTO(
                partsEntity.getPhone(),
                partsEntity.getCity(),
                partsEntity.getImages()

        );
    }

//    @Override
//    public List<EquipmentSummaryDTO> getAllEquipmentSummary() {
//        return equipmentRepository
//                .findAll()
//                .stream()
//                .map(EquipmentServiceImpl::toEquipmentSummary)
//                .toList();
//    }

//    Integer phone,
//    String city,
//    List<String> images
}
