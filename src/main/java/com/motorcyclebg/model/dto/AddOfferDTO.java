package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.EngineTypeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record AddOfferDTO(
        @NotEmpty(message = "{add.offer.description.not.empty}")
        @Size(message = "{add.offer.description.size}", min=5, max=1500)
        String description,
        @NotNull(message = "{add.offer.mileage.not.empty}")
        @PositiveOrZero
        Integer mileage,
        @NotNull(message = "{add.offer.price.not.empty}")
        @PositiveOrZero
        Integer price,
        @NotNull(message = "{add.offer.engine.type.not.empty}")
        EngineTypeEnum engineType
) {

    public static AddOfferDTO empty() {
        return new AddOfferDTO(null, null,null, null);
    }

}
