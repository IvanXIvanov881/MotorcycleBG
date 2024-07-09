package com.motorcyclebg.service.impl;

import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.model.enums.UserRoleEnum;
import com.motorcyclebg.model.user.MotorcyclebgUserDetails;
import com.motorcyclebg.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
        return new MotorcyclebgUserDetails(
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRoles().stream().map(r -> r.getRole()).map(MotorcyclebgUserDetailsService::map).toList(),
                userEntity.getFirstName(),
                userEntity.getLastName()
        );
    }

    private static GrantedAuthority map(UserRoleEnum role) {
        return new SimpleGrantedAuthority("ROLE_" + role);
    }

}
