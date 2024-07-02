package com.motorcyclebg.service;


import com.motorcyclebg.model.dto.UserLoginDTO;
import com.motorcyclebg.model.dto.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);
    boolean login(UserLoginDTO userLoginDTO);
    void logout();
}
