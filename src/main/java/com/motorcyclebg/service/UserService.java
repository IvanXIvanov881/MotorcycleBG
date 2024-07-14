package com.motorcyclebg.service;

import com.motorcyclebg.model.dto.UserRegistrationDTO;
import com.motorcyclebg.model.entity.UserEntity;
import java.util.Optional;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    Optional<UserEntity> findUserByEmail(String value);


}
