package com.roguethree.gymchampionexerciseap.services.jpaServices;

import com.roguethree.gymchampionexerciseap.model.Exercise;
import com.roguethree.gymchampionexerciseap.model.enums.Equipment;
import com.roguethree.gymchampionexerciseap.repository.ExerciseRepository;
import com.roguethree.gymchampionexerciseap.services.ExerciseService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class JpaExerciseService implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public JpaExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Stream<Exercise> findAll() {
        Iterable<Exercise> iterable = exerciseRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false);
    }

//    @Override
//    public Stream<Exercise> findByBodyPartName(String bodyPartName) {
//        return exerciseRepository.findAllByBodyPartName(bodyPartName);
//    }

    @Override
    public Optional<Exercise> findById(Long id) {
        return exerciseRepository.findById(id);
    }

    @Override
    public Optional<Exercise> findByName(String name) {
        return exerciseRepository.findByName(name);
    }

    @Override
    public Stream<Exercise> findByEquipment(Equipment equipment) {
        return exerciseRepository.findByEquipment(equipment);
    }
}
