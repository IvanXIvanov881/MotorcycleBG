package com.motorcyclebg.model.entity;

import com.motorcyclebg.model.enums.PartsConditionTypeEnum;
import com.motorcyclebg.model.enums.PartsTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parts")
public class PartsEntity extends BaseEntity {


    @Enumerated(EnumType.STRING)
    private PartsTypeEnum partsType;

    private String partsBrand;

    @Enumerated(EnumType.STRING)
    private PartsConditionTypeEnum partsConditionType;

    @NotEmpty
    @Size(max = 1005)
    private String partsDescription;

    @PositiveOrZero
    private Integer partsPrice;

    @PositiveOrZero
    private Integer phone;

    @Size(max = 21)
    private String city;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "images")
    private List<@URL @NotBlank String> images = new ArrayList<>();


    public PartsTypeEnum getPartsType() {
        return partsType;
    }

    public PartsEntity setPartsType(PartsTypeEnum partsType) {
        this.partsType = partsType;
        return this;
    }

    public String getPartsBrand() {
        return partsBrand;
    }

    public PartsEntity setPartsBrand(String partsBrand) {
        this.partsBrand = partsBrand;
        return this;
    }

    public PartsConditionTypeEnum getPartsConditionType() {
        return partsConditionType;
    }

    public PartsEntity setPartsConditionType(PartsConditionTypeEnum partsConditionType) {
        this.partsConditionType = partsConditionType;
        return this;
    }

    public String getPartsDescription() {
        return partsDescription;
    }

    public PartsEntity setPartsDescription(String partsDescription) {
        this.partsDescription = partsDescription;
        return this;
    }

    public Integer getPartsPrice() {
        return partsPrice;
    }

    public PartsEntity setPartsPrice(Integer partsPrice) {
        this.partsPrice = partsPrice;
        return this;
    }

    public List<String> getImages() {
        return images;
    }

    public PartsEntity setImages(List<String> images) {
        this.images = images;
        return this;
    }

    public Integer getPhone() {
        return phone;
    }

    public PartsEntity setPhone(Integer phone) {
        this.phone = phone;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PartsEntity setCity(String city) {
        this.city = city;
        return this;
    }
}