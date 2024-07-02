package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.AddOfferDTO;
import com.motorcyclebg.model.dto.OfferDetailsDTO;
import com.motorcyclebg.model.dto.OfferSummaryDTO;
import com.motorcyclebg.model.entity.OfferEntity;
import com.motorcyclebg.repository.OfferRepository;
import com.motorcyclebg.service.ExRateService;
import com.motorcyclebg.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private ExRateService exRateService;

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
                .orElseThrow();
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
                offerEntity.getDescription(),
                offerEntity.getMileage(),
                offerEntity.getEngine());
    }

    private OfferDetailsDTO toOfferDetails(OfferEntity offerEntity){
        //TODO use mapping library
        return new OfferDetailsDTO(offerEntity.getId(),
                offerEntity.getDescription(),
                offerEntity.getMileage(),
                offerEntity.getPrice(),
                offerEntity.getEngine(),
                exRateService.allSupportedCurrencies()
        );
    }


    private static OfferEntity map(AddOfferDTO addOfferDTO) {

        //TODO: we have to use ModelMapper
        return new OfferEntity()
                .setDescription(addOfferDTO.description())
                .setEngine(addOfferDTO.engineType())
                .setMileage(addOfferDTO.mileage())
                .setPrice(addOfferDTO.price());
    }

}
