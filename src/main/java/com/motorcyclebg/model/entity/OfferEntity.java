package com.motorcyclebg.model.entity;

import com.motorcyclebg.model.enums.EngineTypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Integer mileage;

    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;

    public Integer getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OfferEntity setId(Long id) {
        this.id = id;
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
}