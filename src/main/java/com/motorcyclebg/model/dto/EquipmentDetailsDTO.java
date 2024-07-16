package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.EquipmentConditionTypeEnum;
import com.motorcyclebg.model.enums.EquipmentTypeEnum;

import java.util.List;

public record EquipmentDetailsDTO(
        Long id,
        EquipmentTypeEnum equipmentType,
        String equipmentBrand,
        EquipmentConditionTypeEnum equipmentConditionType,
        String equipmentDescription,
        Integer equipmentPrice,
        List<String> allCurrencies,
        List<String> images
) {
}
