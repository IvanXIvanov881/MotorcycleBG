package com.motorcyclebg.model.entity;

import com.motorcyclebg.model.enums.EngineTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.URL;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @NotEmpty
    private String description;
    @Positive
    private Integer mileage;
    @Positive
    private Integer price;
    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "images")
    private List<@URL @NotBlank String> images = new ArrayList<>();

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

    public OfferEntity setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public List<String> getImages() {
        return images;
    }

    public OfferEntity setImages(List<String> images) {
        this.images = images;
        return this;
    }
}