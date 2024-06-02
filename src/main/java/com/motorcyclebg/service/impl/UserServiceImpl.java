package com.motorcyclebg.service.impl;
import com.motorcyclebg.model.UserRegistrationDTO;
import com.motorcyclebg.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public void registerUser(UserRegistrationDTO userRegistration) {

        System.out.println("The user received is: " + userRegistration);

    }
}
