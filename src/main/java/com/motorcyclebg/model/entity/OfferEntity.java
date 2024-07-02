package com.motorcyclebg.model.entity;

import com.motorcyclebg.model.enums.EngineTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{

    @NotEmpty
    private String description;
    @Positive
    private Integer mileage;
    @Positive
    private Integer price;

    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;

    public Integer getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineTypeEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineTypeEnum engine) {
        this.engine = engine;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferEntity setPrice(int price) {
        this.price = price;
        return this;
    }

}