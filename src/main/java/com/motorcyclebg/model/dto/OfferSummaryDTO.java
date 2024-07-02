package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.EngineTypeEnum;

public record OfferSummaryDTO(Long id,
                              String description,
                              Integer mileage,
                              EngineTypeEnum engineType) {
}
