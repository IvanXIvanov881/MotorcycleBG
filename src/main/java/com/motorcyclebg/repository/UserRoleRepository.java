package com.motorcyclebg.repository;

import com.motorcyclebg.model.entity.UserRoleEntity;
import com.motorcyclebg.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    Optional<UserRoleEntity> findByRole(UserRoleEnum role);

}
