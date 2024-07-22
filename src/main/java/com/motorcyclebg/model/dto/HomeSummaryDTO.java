package com.motorcyclebg.model.dto;

import java.util.List;

public record HomeSummaryDTO(
        //Long id,
        Integer phone,
        String city,
        List<String> images
) {
}
