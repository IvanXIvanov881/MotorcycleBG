package com.motorcyclebg.service;

import com.motorcyclebg.model.dto.AddOfferDTO;
import com.motorcyclebg.model.dto.OfferDetailsDTO;
import com.motorcyclebg.model.dto.OfferSummaryDTO;

import java.util.List;

public interface PartsService {

    long createParts(AddOfferDTO addOfferDTO);

    OfferDetailsDTO getOfferParts(Long id);

    void deleteParts(long offerId);

    List<OfferSummaryDTO> getAllPartsSummary();

}
