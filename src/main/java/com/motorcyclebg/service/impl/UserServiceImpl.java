package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.UserLoginDTO;
import com.motorcyclebg.model.dto.UserRegistrationDTO;
import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.repository.UserRepository;
import com.motorcyclebg.service.CurrentUser;
import com.motorcyclebg.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder,
                           UserRepository userRepository,
                           CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistration) {

        userRepository.save(map(userRegistration));
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {

        UserEntity mappedEntity = modelMapper.map(userRegistrationDTO, UserEntity.class);
        mappedEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        return mappedEntity;
    }

}
