package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.dto.UserDetailsDTO;
import com.motorcyclebg.model.dto.UserSummaryDTO;
import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.repository.UserRepository;
import com.motorcyclebg.service.exception.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    private UserEntity userEntity;

    @BeforeEach
    void setUp() {
        userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setEmail("test@example.com");
        userEntity.setFirstName("John");
        userEntity.setLastName("Doe");
    }

    @Test
    void getUserDetails_ShouldReturnUserDetails() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        UserDetailsDTO userDetails = adminService.getUserDetails(1L);

        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals(1L, userDetails.id());
        Assertions.assertEquals("test@example.com", userDetails.email());
        Assertions.assertEquals("John", userDetails.firstName());
        Assertions.assertEquals("Doe", userDetails.lastName());

        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void getUserDetails_ShouldThrowException_WhenUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ObjectNotFoundException.class, () -> adminService.getUserDetails(1L));

        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void deleteUser_ShouldDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        adminService.deleteUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    void getAllUsersSummary_ShouldReturnListOfUserSummary() {
        when(userRepository.findAll()).thenReturn(List.of(userEntity));

        List<UserSummaryDTO> userSummaries = adminService.getAllUsersSummary();

        Assertions.assertNotNull(userSummaries);
        Assertions.assertEquals(1, userSummaries.size());
        Assertions.assertEquals("test@example.com", userSummaries.get(0).email());
        Assertions.assertEquals("John", userSummaries.get(0).firstName());

        verify(userRepository, times(1)).findAll();
    }
}
