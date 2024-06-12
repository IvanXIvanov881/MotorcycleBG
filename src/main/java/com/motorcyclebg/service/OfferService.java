package com.motorcyclebg.service;

import com.motorcyclebg.model.AddOfferDTO;
import com.motorcyclebg.model.OfferDetailsDTO;

public interface OfferService {

    long createOrder(AddOfferDTO addOfferDTO);

    OfferDetailsDTO getOfferDetails(Long id);
}
