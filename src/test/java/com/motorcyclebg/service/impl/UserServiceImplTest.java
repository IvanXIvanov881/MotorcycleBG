package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.UserRegistrationDTO;
import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.model.entity.UserRoleEntity;
import com.motorcyclebg.model.enums.UserRoleEnum;
import com.motorcyclebg.repository.UserRepository;
import com.motorcyclebg.repository.UserRoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRoleRepository roleRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private UserEntity userEntity;
    private UserRegistrationDTO userRegistrationDTO;
    private UserRoleEntity userRoleEntity;

    @BeforeEach
    void setUp() {
        userRegistrationDTO = new UserRegistrationDTO();
        userRegistrationDTO.setEmail("test@example.com");
        userRegistrationDTO.setPassword("password");

        userEntity = new UserEntity();
        userEntity.setEmail("test@example.com");
        userEntity.setPassword("encodedPassword");

        userRoleEntity = new UserRoleEntity();
        userRoleEntity.setRole(UserRoleEnum.USER);
    }

    @Test
    void registerUser_ShouldSaveUser() {
        when(modelMapper.map(userRegistrationDTO, UserEntity.class)).thenReturn(userEntity);
        when(roleRepository.findByRole(UserRoleEnum.USER)).thenReturn(Optional.of(userRoleEntity));
        when(passwordEncoder.encode(userRegistrationDTO.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        userService.registerUser(userRegistrationDTO);

        verify(userRepository, times(1)).save(userEntity);
    }

    @Test
    void findUserByEmail_ShouldReturnUser() {
        when(userRepository.findUserByEmail("test@example.com")).thenReturn(Optional.of(userEntity));

        Optional<UserEntity> foundUser = userService.findUserByEmail("test@example.com");

        Assertions.assertTrue(foundUser.isPresent());
        Assertions.assertEquals("test@example.com", foundUser.get().getEmail());
        verify(userRepository, times(1)).findUserByEmail("test@example.com");
    }

    @Test
    void findUserByEmail_ShouldReturnEmpty_WhenUserNotFound() {
        when(userRepository.findUserByEmail("test@example.com")).thenReturn(Optional.empty());

        Optional<UserEntity> foundUser = userService.findUserByEmail("test@example.com");

        Assertions.assertFalse(foundUser.isPresent());
        verify(userRepository, times(1)).findUserByEmail("test@example.com");
    }
}