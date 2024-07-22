package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.EquipmentTypeEnum;

import java.util.List;

public record EquipmentSummaryDTO(
        Long id,
        EquipmentTypeEnum equipmentType,
        String equipmentBrand,
        String city,
        Integer equipmentPrice,
        List<String> images,
        List<String> allCurrencies
) {
}
