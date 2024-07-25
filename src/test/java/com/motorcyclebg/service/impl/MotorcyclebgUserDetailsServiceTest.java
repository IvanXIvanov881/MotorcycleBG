package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.model.user.MotorcyclebgUserDetails;
import com.motorcyclebg.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class MotorcyclebgUserDetailsServiceTest {

    static String TEST_EMAIL = "user@example.com";
    static String NOT_EXISTENT_EMAIL = "noemail@example.com";
    private MotorcyclebgUserDetailsService toTest;

    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {

        mockUserRepository = Mockito.mock(UserRepository.class);

        toTest = new MotorcyclebgUserDetailsService(mockUserRepository);
    }

    @Test
    void testLoadUserByEmail_UserFound() {

        UserEntity testUser = new UserEntity()
                .setEmail(TEST_EMAIL)
                .setPassword("123")
                .setFirstName("Ivan")
                .setLastName("Ivanov");

        when(mockUserRepository.findUserByEmail(TEST_EMAIL))
                .thenReturn(Optional.of(testUser));

        UserDetails userDetails = toTest.loadUserByUsername(TEST_EMAIL);

        Assertions.assertInstanceOf(MotorcyclebgUserDetails.class, userDetails);

        MotorcyclebgUserDetails motorcyclebgUserDetails = (MotorcyclebgUserDetails) userDetails;
        Assertions.assertEquals(TEST_EMAIL, userDetails.getUsername());
        Assertions.assertEquals(testUser.getPassword(), userDetails.getPassword());
        Assertions.assertEquals(testUser.getFirstName(), motorcyclebgUserDetails.getFirstName());
        Assertions.assertEquals(testUser.getLastName(), motorcyclebgUserDetails.getLastName());
        Assertions.assertEquals(testUser.getFirstName() + " " + testUser.getLastName(), motorcyclebgUserDetails.getFullName());
        Assertions.assertEquals(testUser.getEmail(), motorcyclebgUserDetails.getEmail());

        Assertions.assertEquals(0, userDetails.getAuthorities().size());

        Optional<? extends GrantedAuthority> admin = userDetails.getAuthorities()
                .stream()
                .filter(a -> "ADMIN".equals(a.getAuthority())).findAny();

        Assertions.assertFalse(admin.isPresent());

        Optional<? extends GrantedAuthority> user = userDetails.getAuthorities()
                .stream()
                .filter(a -> "USER".equals(a.getAuthority())).findAny();

        Assertions.assertFalse(user.isPresent());
    }

    @Test
    void testLoadUserByUsername_UserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> toTest.loadUserByUsername(NOT_EXISTENT_EMAIL)
        );

    }

}
