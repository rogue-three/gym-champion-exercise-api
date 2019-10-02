package com.roguethree.gymchampionexerciseap.repository;

import com.roguethree.gymchampionexerciseap.model.BodyPart;
import com.roguethree.gymchampionexerciseap.model.Exercise;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    Optional<Exercise> findByName(String name);



    Stream<Exercise> findAllByBodyParts(BodyPart bodyPartName);

    Stream<Exercise> findAllByBodyParts(String bodyPartName);

    Stream<Exercise> findAllByBodyPartsName(String bodyPartName);
}
