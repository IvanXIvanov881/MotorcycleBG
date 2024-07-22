package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;
import java.util.List;

public class AddOfferDTO {

    @NotNull(message = "{add.offer.category.type.not.empty}")
    private CategoryTypeEnum categoryType;
    @NotNull(message = "{add.offer.brand.type.not.empty}")
    private BrandTypeEnum brandType;
    @NotNull(message = "{add.offer.model.not.empty}")
    @Size(message = "{add.offer.model.size}", min = 1, max = 20)
    private String model;
    @PositiveOrZero
    private Integer hp;
    @NotNull(message = "{add.offer.condition.type.not.empty}")
    private ConditionTypeEnum conditionType;
    @NotNull(message = "{add.offer.engine.type.not.empty}")
    private EngineTypeEnum engineType;
    @NotNull(message = "{add.offer.transmission.type.not.empty}")
    private TransmissionTypeEnum transmissionType;
    @NotNull(message = "{add.offer.cubic.centimeters.not.empty}")
    @PositiveOrZero
    private Integer cubicCentimeters;
    @NotNull(message = "{add.offer.mileage.not.empty}")
    @PositiveOrZero
    private Integer mileage;
    @NotNull(message = "{add.offer.year.not.empty}")
    @PositiveOrZero
    private Integer year;
    @NotNull(message = "{add.offer.price.not.empty}")
    @PositiveOrZero
    private Integer price;
    @NotEmpty(message = "{add.offer.description.not.empty}")
    @Size(message = "{add.offer.description.size}", min = 1, max = 1000)
    private String description;
    @Size(message = "{add.offer.color.size}", max = 30)
    private String color;
    @NotNull(message = "{add.offer.phone.not.empty}")
    @PositiveOrZero
    private Integer phone;

    @Size(message = "{add.offer.city.size}", max = 20)
    private String city;

    private List<@URL @NotBlank String> images;

    public AddOfferDTO() {
    }

    public String getColor() {
        return color;
    }

    public AddOfferDTO setColor(String color) {
        this.color = color;
        return this;
    }

    public ConditionTypeEnum getConditionType() {
        return conditionType;
    }

    public AddOfferDTO setConditionType(ConditionTypeEnum conditionType) {
        this.conditionType = conditionType;
        return this;
    }

    public Integer getCubicCentimeters() {
        return cubicCentimeters;
    }

    public AddOfferDTO setCubicCentimeters(Integer cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
        return this;
    }

    public CategoryTypeEnum getCategoryType() {
        return categoryType;
    }

    public AddOfferDTO setCategoryType(CategoryTypeEnum categoryType) {
        this.categoryType = categoryType;
        return this;
    }

    public BrandTypeEnum getBrandType() {
        return brandType;
    }

    public AddOfferDTO setBrandType(BrandTypeEnum brandType) {
        this.brandType = brandType;
        return this;
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

    public TransmissionTypeEnum getTransmissionType() {
        return transmissionType;
    }

    public AddOfferDTO setTransmissionType(TransmissionTypeEnum transmissionType) {
        this.transmissionType = transmissionType;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public AddOfferDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public List<String> getImages() {
        return images;
    }

    public AddOfferDTO setImages(List<String> images) {
        this.images = images;
        return this;
    }

    public String getModel() {
        return model;
    }

    public AddOfferDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getHp() {
        return hp;
    }

    public AddOfferDTO setHp(Integer hp) {
        this.hp = hp;
        return this;
    }

    public Integer getPhone() {
        return phone;
    }

    public AddOfferDTO setPhone(Integer phone) {
        this.phone = phone;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddOfferDTO setCity(String city) {
        this.city = city;
        return this;
    }

}
