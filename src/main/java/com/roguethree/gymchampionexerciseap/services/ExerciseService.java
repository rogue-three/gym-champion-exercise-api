package com.roguethree.gymchampionexerciseap.services;

import com.roguethree.gymchampionexerciseap.model.Exercise;
import com.roguethree.gymchampionexerciseap.model.enums.Equipment;

import java.util.Optional;
import java.util.stream.Stream;

public interface ExerciseService extends CrudService<Exercise, Long> {

//    Stream<Exercise> findByBodyPartName(String bodyPartName);

    Stream<Exercise> findByEquipment(Equipment equipment);
}
