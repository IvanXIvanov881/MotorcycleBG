package com.motorcyclebg.model;

import com.motorcyclebg.model.enums.EngineTypeEnum;

public record OfferDetailsDTO(Long id,
                             String description,
                             Integer mileage,
                             EngineTypeEnum engineType) {

}
