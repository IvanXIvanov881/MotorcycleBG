package com.motorcyclebg.model;

import com.motorcyclebg.model.enums.EngineTypeEnum;

public record AddOfferDTO(
    String description,
    EngineTypeEnum engineType
) {

    public static AddOfferDTO empty() {
        return new AddOfferDTO(null, null);
    }

}
