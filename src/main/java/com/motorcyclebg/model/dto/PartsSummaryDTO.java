package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.PartsConditionTypeEnum;
import com.motorcyclebg.model.enums.PartsTypeEnum;

import java.util.List;

public record PartsSummaryDTO(
        Long id,
        PartsTypeEnum partsType,
        Integer equipmentPrice,
        List<String> allCurrencies
) {
}
