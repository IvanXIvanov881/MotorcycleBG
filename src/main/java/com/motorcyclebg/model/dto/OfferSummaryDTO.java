package com.motorcyclebg.model.dto;

import com.motorcyclebg.model.enums.BrandTypeEnum;
import java.util.List;

public record OfferSummaryDTO(Long id,
                              BrandTypeEnum brandType,
                              Integer mileage,
                              Integer year,
                              Integer cubicCentimeters,
                              Integer price,
                              List<String> allCurrencies) {
}
