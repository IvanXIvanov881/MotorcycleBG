package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.List;

public class MotorcyclebgUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MotorcyclebgUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        return userRepository
                .findByEmail(email)
                .map(MotorcyclebgUserDetailsService::map)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with email " + email + " not found!"));

    }

    private static UserDetails map(UserEntity userEntity) {
        return User.withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(List.of())/*TODO*/
                .disabled(false)
                .build();
    }

}
