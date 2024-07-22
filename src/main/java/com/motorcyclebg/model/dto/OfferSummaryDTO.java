package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.BrandTypeEnum;
import java.util.List;

public record OfferSummaryDTO(Long id,
                              BrandTypeEnum brandType,
                              String model,
                              Integer mileage,
                              Integer year,
                              Integer cubicCentimeters,
                              String city,
                              Integer price,
                              List<String> images,
                              List<String> allCurrencies) {
}
