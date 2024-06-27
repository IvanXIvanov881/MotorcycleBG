package com.motorcyclebg.service;


import com.motorcyclebg.model.UserLoginDTO;
import com.motorcyclebg.model.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);
    boolean login(UserLoginDTO userLoginDTO);
    void logout();
}
