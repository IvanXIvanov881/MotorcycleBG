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
}
