package com.roguethree.gymchampionexerciseap.services;

import com.roguethree.gymchampionexerciseap.model.Exercise;

import java.util.Optional;

public interface ExerciseService extends CrudService<Exercise, Long> {

    Optional<Exercise> findByBodyPartName(String bodyPartName);

}
