package com.motorcyclebg.web;

import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.context.annotation.Import;
import com.motorcyclebg.config.TestConfig;

import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestConfig.class)
public class RegistrationControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testRegistration() throws Exception {

        mockMvc.perform(post("/users/register")
                        .param("email", "anna@example.com")
                        .param("firstName", "Anna")
                        .param("lastName", "Petrova")
                        .param("password", "topsecret")
                        .param("confirmPassword", "topsecret")
                        .with(csrf())
                ).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        Optional<UserEntity> userEntityOpt = userRepository.findUserByEmail("anna@example.com");

        Assertions.assertTrue(userEntityOpt.isPresent());

        UserEntity userEntity = userEntityOpt.get();

        Assertions.assertEquals("Anna", userEntity.getFirstName());
        Assertions.assertEquals("Petrova", userEntity.getLastName());

        Assertions.assertTrue(passwordEncoder.matches("topsecret", userEntity.getPassword()));
    }
}