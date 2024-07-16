package com.motorcyclebg.service;

import com.motorcyclebg.model.dto.*;

import java.util.List;

public interface EquipmentService {

    long createEquipment(AddEquipmentDTO addEquipmentDTO);

    EquipmentDetailsDTO getEquipmentDetails(Long id);

    void deleteEquipment(long offerId);

    List<EquipmentSummaryDTO> getAllEquipmentSummary();
}
