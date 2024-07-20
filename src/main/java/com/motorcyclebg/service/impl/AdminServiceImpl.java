package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.UserDetailsDTO;
import com.motorcyclebg.model.dto.UserSummaryDTO;
import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.repository.UserRepository;
import com.motorcyclebg.service.AdminService;
import com.motorcyclebg.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository
    ) {
        this.userRepository = userRepository;

    }


    @Override
    public UserDetailsDTO getUserDetails(Long id) {

        return this.userRepository
                .findById(id)
                .map(this::toUserDetails)
                .orElseThrow(() -> new ObjectNotFoundException("Exception with ID: ", id));
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserSummaryDTO> getAllUsersSummary() {
        return userRepository
                .findAll()
                .stream()
                .map(AdminServiceImpl::toUserSummary)
                .toList();
    }

    private static UserSummaryDTO toUserSummary(UserEntity userEntity) {

        return new UserSummaryDTO(userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getFirstName()

        );
    }

    private UserDetailsDTO toUserDetails(UserEntity userEntity) {

        return new UserDetailsDTO(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getFirstName(),
                userEntity.getLastName()

        );
    }


}
