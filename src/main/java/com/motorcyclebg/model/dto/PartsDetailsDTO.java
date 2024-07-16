package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.PartsConditionTypeEnum;
import com.motorcyclebg.model.enums.PartsTypeEnum;

import java.util.List;

public record PartsDetailsDTO(
        Long id,
        PartsTypeEnum partsType,
        String partsBrand,
        PartsConditionTypeEnum partsConditionType,
        String partsDescription,
        Integer partsPrice,
        List<String> allCurrencies,
        List<String> images
) {
}
