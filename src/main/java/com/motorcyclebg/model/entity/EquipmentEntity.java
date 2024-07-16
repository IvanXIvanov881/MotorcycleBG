package com.motorcyclebg.model.entity;

import com.motorcyclebg.model.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipment")
public class EquipmentEntity extends BaseEntity {


    @Enumerated(EnumType.STRING)
    private EquipmentTypeEnum equipmentType;

    private String equipmentBrand;

    @Enumerated(EnumType.STRING)
    private EquipmentConditionTypeEnum equipmentConditionType;

    @NotEmpty
    @Size(max = 1005)
    private String equipmentDescription;

    @PositiveOrZero
    private Integer equipmentPrice;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "images")
    private List<@URL @NotBlank String> images = new ArrayList<>();


    public EquipmentTypeEnum getEquipmentType() {
        return equipmentType;
    }

    public EquipmentEntity setEquipmentType(EquipmentTypeEnum equipmentType) {
        this.equipmentType = equipmentType;
        return this;
    }

    public String getEquipmentBrand() {
        return equipmentBrand;
    }

    public EquipmentEntity setEquipmentBrand(String equipmentBrand) {
        this.equipmentBrand = equipmentBrand;
        return this;
    }

    public EquipmentConditionTypeEnum getEquipmentConditionType() {
        return equipmentConditionType;
    }

    public EquipmentEntity setEquipmentConditionType(EquipmentConditionTypeEnum equipmentConditionType) {
        this.equipmentConditionType = equipmentConditionType;
        return this;
    }

    public Integer getEquipmentPrice() {
        return equipmentPrice;
    }

    public EquipmentEntity setEquipmentPrice(Integer equipmentPrice) {
        this.equipmentPrice = equipmentPrice;
        return this;
    }

    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public EquipmentEntity setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
        return this;
    }

    public List<String> getImages() {
        return images;
    }

    public EquipmentEntity setImages(List<String> equipmentImages) {
        this.images = equipmentImages;
        return this;
    }
}
