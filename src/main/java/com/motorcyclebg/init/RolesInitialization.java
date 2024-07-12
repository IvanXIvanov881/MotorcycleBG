package com.motorcyclebg.service;

import com.motorcyclebg.model.entity.UserRoleEntity;
import com.motorcyclebg.model.enums.UserRoleEnum;
import com.motorcyclebg.repository.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RolesInitialization implements CommandLineRunner {

    private final UserRoleRepository roleRepository;

    public RolesInitialization(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Arrays.stream(UserRoleEnum.values())
                    .forEach(role -> {
                        UserRoleEntity userRole = new UserRoleEntity();
                        userRole.setRole(role);
                        roleRepository.save(userRole);
                    });
        }
    }
}