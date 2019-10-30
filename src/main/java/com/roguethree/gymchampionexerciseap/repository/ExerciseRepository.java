package com.roguethree.gymchampionexerciseap.repository;

import com.roguethree.gymchampionexerciseap.model.Exercise;
import com.roguethree.gymchampionexerciseap.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Optional<Exercise> findByName(String name);

    Stream<Exercise> findAllByEquipment_EquipmentName(String equipmentName);

//    @Query(value =
//            "SELECT * FROM ", nativeQuery=true)
//    Stream<Exercise> findAllByBodyPartName(@Param("body_part_name") String bodyPartName);

}
