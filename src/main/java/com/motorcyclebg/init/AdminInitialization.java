package com.motorcyclebg.init;

import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.model.entity.UserRoleEntity;
import com.motorcyclebg.model.enums.UserRoleEnum;
import com.motorcyclebg.repository.UserRepository;
import com.motorcyclebg.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AdminInitialization implements CommandLineRunner {

    @Value("${admin.email}")
    private String adminEmail;
    @Value("${admin.password}")
    private String adminPassword;
    @Value("${admin.firstName}")
    private String adminFirstName;
    @Value("${admin.lastName}")
    private String adminLastName;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    public AdminInitialization(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            UserEntity admin = new UserEntity();

            admin.setEmail(adminEmail);
            admin.setPassword(passwordEncoder.encode(adminPassword));
            admin.setFirstName(adminFirstName);
            admin.setLastName(adminLastName);


            Set<UserRoleEntity> roles = Set.of(UserRoleEnum.ADMIN,UserRoleEnum.USER)
                    .stream()
                    .map(this::getOrCreateUserRole)
                    .collect(Collectors.toSet());

            admin.setRoles(roles);
            userRepository.save(admin);
        }
    }

    private UserRoleEntity getOrCreateUserRole(UserRoleEnum roleEnum) {

        return userRoleRepository.findByRole(roleEnum)
                .orElseGet(() -> {
                    UserRoleEntity role = new UserRoleEntity();
                    role.setRole(roleEnum);
                    return userRoleRepository.save(role);
                });
    }
}