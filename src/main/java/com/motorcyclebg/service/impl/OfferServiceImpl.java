package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.AddOfferDTO;
import com.motorcyclebg.model.OfferDetailsDTO;
import com.motorcyclebg.model.entity.OfferEntity;
import com.motorcyclebg.repository.OfferRepository;
import com.motorcyclebg.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public long createOrder(AddOfferDTO addOfferDTO) {
        return offerRepository.save(map(addOfferDTO)).getId();
    }

    @Override
    public OfferDetailsDTO getOfferDetails(Long id) {

        return this.offerRepository
                .findById(id)
                .map(od -> toOfferDetails(od))
                .orElseThrow();
    }

    private static OfferDetailsDTO toOfferDetails(OfferEntity offerEntity){
        //TODO use mapping library
        return new OfferDetailsDTO(offerEntity.getId(),
                offerEntity.getDescription(),
                offerEntity.getMileage(),
                offerEntity.getEngine());
    }

    private static OfferEntity map(AddOfferDTO addOfferDTO) {

        //TODO: we have to use ModelMapper
        return new OfferEntity()
                .setDescription(addOfferDTO.description())
                .setEngine(addOfferDTO.engineType())
                .setMileage(addOfferDTO.mileage());

    }

}
