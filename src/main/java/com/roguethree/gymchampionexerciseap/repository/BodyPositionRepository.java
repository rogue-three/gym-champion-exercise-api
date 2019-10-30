package com.roguethree.gymchampionexerciseap.repository;

import com.roguethree.gymchampionexerciseap.model.BodyPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BodyPositionRepository extends JpaRepository<BodyPosition, Long> {

    Optional<BodyPosition> findByBodyPositionName(String name);
}
