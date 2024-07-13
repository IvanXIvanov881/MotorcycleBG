package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.AddOfferDTO;
import com.motorcyclebg.model.dto.OfferDetailsDTO;
import com.motorcyclebg.model.dto.OfferSummaryDTO;
import com.motorcyclebg.model.entity.OfferEntity;
import com.motorcyclebg.repository.OfferRepository;
import com.motorcyclebg.service.ExRateService;
import com.motorcyclebg.service.OfferService;
import com.motorcyclebg.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private static ExRateService exRateService;

    public OfferServiceImpl(OfferRepository offerRepository,
                            ExRateService exRateService) {
        this.offerRepository = offerRepository;
        this.exRateService = exRateService;
    }

    @Override
    public long createOffer(AddOfferDTO addOfferDTO) {
        return offerRepository.save(map(addOfferDTO)).getId();
    }

    @Override
    public OfferDetailsDTO getOfferDetails(Long id) {

        return this.offerRepository
                .findById(id)
                .map(this::toOfferDetails)
                .orElseThrow(()-> new ObjectNotFoundException("We have a problem... Id: ", id));
    }

    @Override
    public void deleteOffer(long offerId) {
        offerRepository.deleteById(offerId);
    }

    @Override
    public List<OfferSummaryDTO> getAllOffersSummary() {
        return offerRepository
                .findAll()
                .stream()
                .map(OfferServiceImpl::toOfferSummary)
                .toList();
    }

    private static OfferSummaryDTO toOfferSummary(OfferEntity offerEntity){
        //TODO use mapping library
        return new OfferSummaryDTO(offerEntity.getId(),
                offerEntity.getBrand(),
                offerEntity.getMileage(),
                offerEntity.getYear(),
                //offerEntity.getDescription(),
                //offerEntity.getEngine(),
                //offerEntity.getTransmission(),
                offerEntity.getPrice(),
                exRateService.allSupportedCurrencies()
        );
    }

    private OfferDetailsDTO toOfferDetails(OfferEntity offerEntity){
        //TODO use mapping library
        return new OfferDetailsDTO(
                offerEntity.getId(),
                offerEntity.getBrand(),
                offerEntity.getCategory(),
                offerEntity.getCubicCentimeters(),
                offerEntity.getMileage(),
                offerEntity.getYear(),
                offerEntity.getEngine(),
                offerEntity.getTransmission(),
                offerEntity.getConditionType(),
                offerEntity.getColor(),
                offerEntity.getDescription(),
                offerEntity.getPrice(),
                exRateService.allSupportedCurrencies(),
                offerEntity.getImages()
        );
    }


    private static OfferEntity map(AddOfferDTO addOfferDTO) {

        //TODO: we have to use ModelMapper
        return new OfferEntity()
                .setBrand(addOfferDTO.getBrandType())
                .setCategory(addOfferDTO.getCategoryType())
                .setDescription(addOfferDTO.getDescription())
                .setEngine(addOfferDTO.getEngineType())
                .setCubicCentimeters(addOfferDTO.getCubicCentimeters())
                .setTransmission(addOfferDTO.getTransmissionType())
                .setMileage(addOfferDTO.getMileage())
                .setYear(addOfferDTO.getYear())
                .setPrice(addOfferDTO.getPrice())
                .setConditionType(addOfferDTO.getConditionType())
                .setColor(addOfferDTO.getColor())
                .setImages(addOfferDTO.getImages());
    }

}