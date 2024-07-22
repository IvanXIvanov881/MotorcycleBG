package com.motorcyclebg.service;

import com.motorcyclebg.model.dto.HomeSummaryDTO;
import java.util.List;

public interface HomeService {

    List<HomeSummaryDTO> getAllLastSummaries();
}
