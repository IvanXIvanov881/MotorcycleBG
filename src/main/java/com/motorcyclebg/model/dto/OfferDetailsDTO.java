package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.*;

import java.util.List;

public record OfferDetailsDTO(Long id,
                              BrandTypeEnum brandType,
                              String model,
                              Integer hp,
                              CategoryTypeEnum categoryType,
                              Integer cubicCentimeters,
                              Integer mileage,
                              Integer year,
                              EngineTypeEnum engineType,
                              TransmissionTypeEnum transmissionType,
                              ConditionTypeEnum conditionType,
                              String color,
                              String description,
                              Integer phone,
                              String city,
                              Integer price,
                              List<String> allCurrencies,
                              List<String> images) {

}
