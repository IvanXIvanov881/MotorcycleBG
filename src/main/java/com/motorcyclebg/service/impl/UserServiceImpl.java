package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.UserRegistrationDTO;
import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.model.entity.UserRoleEntity;
import com.motorcyclebg.model.enums.UserRoleEnum;
import com.motorcyclebg.repository.UserRepository;
import com.motorcyclebg.repository.UserRoleRepository;
import com.motorcyclebg.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private UserRoleRepository roleRepository;

    public UserServiceImpl(ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder,
                           UserRepository userRepository,
                           UserRoleRepository roleRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistration) {
        userRepository.save(map(userRegistration));
    }

    public Optional<UserEntity> findUserByEmail(String value) {
        return userRepository.findUserByEmail(value);
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {

        UserEntity mappedEntity = modelMapper.map(userRegistrationDTO, UserEntity.class);
        UserRoleEntity role = roleRepository.findByRole(UserRoleEnum.USER);
        mappedEntity.getRoles().add(role);
        mappedEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        return mappedEntity;
    }

}
