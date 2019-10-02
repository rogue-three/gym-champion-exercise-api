package com.roguethree.gymchampionexerciseap.services;

import com.roguethree.gymchampionexerciseap.model.Exercise;

import java.util.Optional;
import java.util.stream.Stream;

public interface ExerciseService extends CrudService<Exercise, Long> {

    Stream<Exercise> findByBodyPartName(String bodyPartName);

}
