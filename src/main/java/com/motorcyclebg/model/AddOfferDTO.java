package com.motorcyclebg.model;

import com.motorcyclebg.model.enums.EngineTypeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record AddOfferDTO(
        @NotEmpty(message = "{add.offer.description.not.empty}")
        String description,
        @NotNull(message = "{add.offer.mileage.not.empty}")
        @PositiveOrZero
        Integer mileage,
        @NotNull(message = "{add.offer.engine.type.not.empty}")
        EngineTypeEnum engineType
) {

    public static AddOfferDTO empty() {
        return new AddOfferDTO(null, null, null);
    }

}
