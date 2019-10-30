package com.roguethree.gymchampionexerciseap.repository;

import com.roguethree.gymchampionexerciseap.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    Optional<Equipment> findByEquipmentName(String name);
}
