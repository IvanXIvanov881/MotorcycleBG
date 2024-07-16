package com.motorcyclebg.service;

import com.motorcyclebg.model.dto.AddPartsDTO;
import com.motorcyclebg.model.dto.PartsDetailsDTO;
import com.motorcyclebg.model.dto.PartsSummaryDTO;

import java.util.List;

public interface PartsService {

    long createParts(AddPartsDTO addPartsDTO);

    PartsDetailsDTO getPartsDetails(Long id);

    void deleteParts(long offerId);

    List<PartsSummaryDTO> getAllPartsSummary();

}