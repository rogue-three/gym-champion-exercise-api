package com.roguethree.gymchampionexerciseap.repository;

import com.roguethree.gymchampionexerciseap.model.Muscle;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MuscleRepository extends CrudRepository<Muscle, Long> {

    Optional<Muscle> findByName(String muscleName);
}
