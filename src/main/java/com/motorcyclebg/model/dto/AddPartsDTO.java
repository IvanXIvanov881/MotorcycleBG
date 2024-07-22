package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public class AddPartsDTO {

    @NotNull(message = "{add.parts.type.not.empty}")
    private PartsTypeEnum partsType;

    @NotNull(message = "{add.parts.brand.not.empty}")
    private String partsBrand;

    @NotNull(message = "{add.parts.condition.type.not.empty}")
    private PartsConditionTypeEnum partsConditionType;

    @NotEmpty(message = "{add.parts.description.not.empty}")
    @Size(message = "{add.parts.description.size}", min = 1, max = 1000)
    private String partsDescription;

    @NotNull(message = "{add.parts.price.not.empty}")
    @PositiveOrZero
    private Integer partsPrice;

    @NotNull(message = "{add.offer.phone.not.empty}")
    @PositiveOrZero
    private Integer phone;

    @Size(message = "{add.offer.city.size}", max = 20)
    private String city;

    private List<@URL @NotBlank String> images;

    public AddPartsDTO() {
    }

    public PartsTypeEnum getPartsType() {
        return partsType;
    }

    public AddPartsDTO setPartsType(PartsTypeEnum partsType) {
        this.partsType = partsType;
        return this;
    }

    public String getPartsBrand() {
        return partsBrand;
    }

    public AddPartsDTO setPartsBrand(String partsBrand) {
        this.partsBrand = partsBrand;
        return this;
    }

    public PartsConditionTypeEnum getPartsConditionType() {
        return partsConditionType;
    }

    public AddPartsDTO setPartsConditionType(PartsConditionTypeEnum partsConditionType) {
        this.partsConditionType = partsConditionType;
        return this;
    }

    public String getPartsDescription() {
        return partsDescription;
    }

    public AddPartsDTO setPartsDescription(String partsDescription) {
        this.partsDescription = partsDescription;
        return this;
    }

    public Integer getPartsPrice() {
        return partsPrice;
    }

    public AddPartsDTO setPartsPrice(Integer partsPrice) {
        this.partsPrice = partsPrice;
        return this;
    }

    public List<String> getImages() {
        return images;
    }

    public AddPartsDTO setImages(List<String> images) {
        this.images = images;
        return this;
    }

    public AddPartsDTO setPhone(Integer phone) {
        this.phone = phone;
        return this;
    }

    public AddPartsDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public Integer getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }
}
