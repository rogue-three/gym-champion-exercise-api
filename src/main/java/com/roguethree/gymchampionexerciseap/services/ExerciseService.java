package com.roguethree.gymchampionexerciseap.services;

import com.roguethree.gymchampionexerciseap.model.Exercise;
import com.roguethree.gymchampionexerciseap.model.Equipment;

import java.util.stream.Stream;

public interface ExerciseService extends CrudService<Exercise, Long> {

//    Stream<Exercise> findByBodyPartName(String bodyPartName);

    Stream<Exercise> findByEquipmentName(String equipment);
}
