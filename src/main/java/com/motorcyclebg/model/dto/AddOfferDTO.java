package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.EngineTypeEnum;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.util.ArrayList;
import java.util.List;

public class AddOfferDTO {

    @NotEmpty(message = "{add.offer.description.not.empty}")
    @Size(message = "{add.offer.description.size}", min = 5, max = 1500)
    private String description;

    @NotNull(message = "{add.offer.mileage.not.empty}")
    @PositiveOrZero
    private Integer mileage;

    @NotNull(message = "{add.offer.price.not.empty}")
    @PositiveOrZero
    private Integer price;

    @NotNull(message = "{add.offer.engine.type.not.empty}")
    private EngineTypeEnum engineType;

    private List<@URL @NotBlank String> images;

    public AddOfferDTO() {
    }

    public String getDescription() {
        return description;
    }

    public AddOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public AddOfferDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public AddOfferDTO setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public EngineTypeEnum getEngineType() {
        return engineType;
    }

    public AddOfferDTO setEngineType(EngineTypeEnum engineType) {
        this.engineType = engineType;
        return this;
    }

    public List<String> getImages() {
        return images;
    }

    public AddOfferDTO setImages(List<String> images) {
        this.images = images;
        return this;
    }
}
