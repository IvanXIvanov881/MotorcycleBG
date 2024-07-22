package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.PartsTypeEnum;
import java.util.List;

public record PartsSummaryDTO(
        Long id,
        PartsTypeEnum partsType,
        String partsBrand,
        String city,
        Integer partsPrice,
        List<String> images,
        List<String> allCurrencies
) {
}
