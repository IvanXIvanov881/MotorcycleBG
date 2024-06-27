package com.motorcyclebg.service;

import com.motorcyclebg.model.AddOfferDTO;
import com.motorcyclebg.model.OfferDetailsDTO;
import com.motorcyclebg.model.OfferSummaryDTO;

import java.util.List;

public interface OfferService {

    long createOffer(AddOfferDTO addOfferDTO);
    OfferDetailsDTO getOfferDetails(Long id);

    void deleteOffer(long offerId);

    List<OfferSummaryDTO> getAllOffersSummary();
}
