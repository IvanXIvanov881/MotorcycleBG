package com.motorcyclebg.model.entity;

import com.motorcyclebg.model.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryTypeEnum category;
    @Enumerated(EnumType.STRING)
    private BrandTypeEnum brand;
    @NotEmpty
    @Size(max = 21)
    private String model;
    @PositiveOrZero
    private Integer hp;

    @Enumerated(EnumType.STRING)
    private ConditionTypeEnum conditionType;
    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;
    @Enumerated(EnumType.STRING)
    private TransmissionTypeEnum transmission;
    @PositiveOrZero
    private Integer cubicCentimeters;
    @PositiveOrZero
    private Integer mileage;
    @PositiveOrZero
    private Integer year;
    @PositiveOrZero
    private Integer price;
    @NotEmpty
    @Size(max = 1005)
    private String description;
    @Size(max = 31)
    private String color;

    @PositiveOrZero
    private Integer phone;

    @Size(max = 21)
    private String city;
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "images")
    private List<@URL @NotBlank String> images = new ArrayList<>();

    public String getColor() {
        return color;
    }

    public OfferEntity setColor(String color) {
        this.color = color;
        return this;
    }

    public ConditionTypeEnum getConditionType() {
        return conditionType;
    }

    public OfferEntity setConditionType(ConditionTypeEnum conditionType) {
        this.conditionType = conditionType;
        return this;
    }

    public CategoryTypeEnum getCategory() {
        return category;
    }

    public OfferEntity setCategory(CategoryTypeEnum category) {
        this.category = category;
        return this;
    }

    public BrandTypeEnum getBrand() {
        return brand;
    }

    public OfferEntity setBrand(BrandTypeEnum brand) {
        this.brand = brand;
        return this;
    }

    public Integer getCubicCentimeters() {
        return cubicCentimeters;
    }

    public OfferEntity setCubicCentimeters(Integer cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
        return this;
    }

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

    public TransmissionTypeEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmissionTypeEnum transmission) {
        this.transmission = transmission;
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

    public Integer getYear() {
        return year;
    }

    public OfferEntity setYear(Integer year) {
        this.year = year;
        return this;
    }

    public List<String> getImages() {
        return images;
    }

    public OfferEntity setImages(List<String> images) {
        this.images = images;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getHp() {
        return hp;
    }

    public OfferEntity setHp(Integer hp) {
        this.hp = hp;
        return this;
    }

    public Integer getPhone() {
        return phone;
    }

    public OfferEntity setPhone(Integer phone) {
        this.phone = phone;
        return this;
    }

    public String getCity() {
        return city;
    }

    public OfferEntity setCity(String city) {
        this.city = city;
        return this;
    }
}