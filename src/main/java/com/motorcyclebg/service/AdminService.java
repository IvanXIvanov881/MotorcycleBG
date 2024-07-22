package com.motorcyclebg.service;

import com.motorcyclebg.model.dto.UserDetailsDTO;
import com.motorcyclebg.model.dto.UserSummaryDTO;
import java.util.List;

public interface AdminService {
    UserDetailsDTO getUserDetails(Long id);

    void deleteUser(long userId);

    List<UserSummaryDTO> getAllUsersSummary();
}
