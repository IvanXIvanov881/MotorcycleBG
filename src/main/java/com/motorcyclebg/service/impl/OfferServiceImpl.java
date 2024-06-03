package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.AddOfferDTO;
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
    public void createOrder(AddOfferDTO addOfferDTO) {
        offerRepository.save(map(addOfferDTO));
    }

    private static OfferEntity map(AddOfferDTO addOfferDTO) {
        return new OfferEntity()
                .setDescription(addOfferDTO.description())
                .setEngine(addOfferDTO.engineType());

    }

}
