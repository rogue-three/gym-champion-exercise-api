package com.roguethree.gymchampionexerciseap.services.jpaServices;

import com.roguethree.gymchampionexerciseap.model.Exercise;
import com.roguethree.gymchampionexerciseap.services.ExerciseService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class JpaExerciseService implements ExerciseService {

    @Override
    public Optional<Exercise> findByBodyPartName(String bodyPartName) {
        return Optional.empty();
    }

    @Override
    public Stream<Exercise> findAll() {
        return null;
    }

    @Override
    public Optional<Exercise> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Exercise> findByName(String name) {
        return Optional.empty();
    }
}
