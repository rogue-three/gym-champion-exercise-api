package com.roguethree.gymchampionexerciseap.repository;

import com.roguethree.gymchampionexerciseap.model.BodyPart;
import com.roguethree.gymchampionexerciseap.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Optional<Exercise> findByName(String name);

//    Stream<Exercise> findExercisesByEquipmentNa

//
//    @Query(value =
//            "SELECT * FROM exercise e " +
//                    "JOIN exercise_to_body_part ebp ON e.id = ebp.exercise_id " +
//                    "JOIN body_part bp ON ebp.body_part_id = bp.body_part_id " +
//                    "WHERE bp.body_part_name = ?1", nativeQuery=true)
//    Stream<Exercise> findAllByBodyPartName(@Param("body_part_name") String bodyPartName);


}
