package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public class AddEquipmentDTO {

    @NotNull(message = "{add.equipment.type.not.empty}")
    private EquipmentTypeEnum equipmentType;

    @NotNull(message = "{add.equipment.brand.not.empty}")
    private String equipmentBrand;

    @NotNull(message = "{add.equipment.condition.type.not.empty}")
    private EquipmentConditionTypeEnum equipmentConditionType;

    @NotEmpty(message = "{add.equipment.description.not.empty}")
    @Size(message = "{add.equipment.description.size}", min = 1, max = 1000)
    private String equipmentDescription;

    @NotNull(message = "{add.equipment.price.not.empty}")
    @PositiveOrZero
    private Integer equipmentPrice;

    @NotNull(message = "{add.offer.phone.not.empty}")
    @PositiveOrZero
    private Integer phone;

    @Size(message = "{add.offer.city.size}", max = 20)
    private String city;

    private List<@URL @NotBlank String> images;

    public AddEquipmentDTO() {
    }

    public EquipmentTypeEnum getEquipmentType() {
        return equipmentType;
    }

    public AddEquipmentDTO setEquipmentType(EquipmentTypeEnum equipmentType) {
        this.equipmentType = equipmentType;
        return this;
    }

    public String getEquipmentBrand() {
        return equipmentBrand;
    }

    public AddEquipmentDTO setEquipmentBrand(String equipmentBrand) {
        this.equipmentBrand = equipmentBrand;
        return this;
    }

    public EquipmentConditionTypeEnum getEquipmentConditionType() {
        return equipmentConditionType;
    }

    public AddEquipmentDTO setEquipmentConditionType(EquipmentConditionTypeEnum equipmentConditionType) {
        this.equipmentConditionType = equipmentConditionType;
        return this;
    }

    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public AddEquipmentDTO setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
        return this;
    }

    public Integer getEquipmentPrice() {
        return equipmentPrice;
    }

    public AddEquipmentDTO setEquipmentPrice(Integer equipmentPrice) {
        this.equipmentPrice = equipmentPrice;
        return this;
    }

    public List<String> getImages() {
        return images;
    }

    public AddEquipmentDTO setImages(List<String> equipmentImages) {
        this.images = equipmentImages;
        return this;
    }

    public Integer getPhone() {
        return phone;
    }

    public AddEquipmentDTO setPhone(Integer phone) {
        this.phone = phone;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddEquipmentDTO setCity(String city) {
        this.city = city;
        return this;
    }
}
