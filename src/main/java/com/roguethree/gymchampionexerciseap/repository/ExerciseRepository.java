package com.roguethree.gymchampionexerciseap.repository;

import com.roguethree.gymchampionexerciseap.model.Exercise;
import com.roguethree.gymchampionexerciseap.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.stream.Stream;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Optional<Exercise> findByName(String name);

    Stream<Exercise> findAllByEquipment_EquipmentName(String equipmentName);

    @Query("SELECT e FROM Exercise e INNER JOIN e.bodyParts b WHERE b.name =?1")
    Stream<Exercise> findAllByBodyPartName(String bodyPartName);

    @Query("select e from Exercise e INNER  JOIN  e.muscles m WHERE m.name =?1")
    Stream<Exercise> findAllByMuscleName(String muscleName);

}
