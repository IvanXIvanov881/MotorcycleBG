package com.motorcyclebg.repository;

import com.motorcyclebg.model.entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository  extends JpaRepository<EquipmentEntity, Long> {

}
