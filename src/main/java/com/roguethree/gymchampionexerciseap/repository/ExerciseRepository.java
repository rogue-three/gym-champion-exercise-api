package com.roguethree.gymchampionexerciseap.repository;

import com.roguethree.gymchampionexerciseap.model.BodyPart;
import com.roguethree.gymchampionexerciseap.model.Exercise;
import com.roguethree.gymchampionexerciseap.model.enums.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Optional<Exercise> findByName(String name);

    Stream<Exercise> findByEquipment(Equipment equipment);

//    @Query(value =
//            "SELECT * FROM ", nativeQuery=true)
//    Stream<Exercise> findAllByBodyPartName(@Param("body_part_name") String bodyPartName);

}
