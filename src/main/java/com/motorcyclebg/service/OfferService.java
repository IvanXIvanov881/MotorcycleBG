package com.motorcyclebg.service;

import com.motorcyclebg.model.dto.AddOfferDTO;
import com.motorcyclebg.model.dto.OfferDetailsDTO;
import com.motorcyclebg.model.dto.OfferSummaryDTO;

import java.util.List;

public interface OfferService {

    long createOffer(AddOfferDTO addOfferDTO);
    OfferDetailsDTO getOfferDetails(Long id);

    void deleteOffer(long offerId);

    List<OfferSummaryDTO> getAllOffersSummary();

}
