package com.motorcyclebg.repository;

import com.motorcyclebg.model.entity.PartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsRepository extends JpaRepository<PartsEntity, Long> {

}
