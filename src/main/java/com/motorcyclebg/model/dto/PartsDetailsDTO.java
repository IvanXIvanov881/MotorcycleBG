package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.EquipmentConditionTypeEnum;
import com.motorcyclebg.model.enums.EquipmentTypeEnum;
import com.motorcyclebg.model.enums.PartsConditionTypeEnum;
import com.motorcyclebg.model.enums.PartsTypeEnum;

import java.util.List;

public record PartsDetailsDTO(
        Long id,
        PartsTypeEnum partsType,
        String partsBrand,
        PartsConditionTypeEnum partsConditionType,
        String partsDescription,
        Integer equipmentPrice,
        List<String> allCurrencies
) {
}
