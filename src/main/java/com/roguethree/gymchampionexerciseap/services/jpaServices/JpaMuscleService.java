package com.roguethree.gymchampionexerciseap.services.jpaServices;

import com.roguethree.gymchampionexerciseap.model.Muscle;
import com.roguethree.gymchampionexerciseap.repository.MuscleRepository;
import com.roguethree.gymchampionexerciseap.services.MuscleService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class JpaMuscleService implements MuscleService {

    private final MuscleRepository muscleRepository;

    public JpaMuscleService(MuscleRepository muscleRepository) {
        this.muscleRepository = muscleRepository;
    }

    @Override
    public Stream<Muscle> findAll() {
        Iterable<Muscle> muscleIterable = muscleRepository.findAll();
        return StreamSupport.stream(muscleIterable.spliterator(), false);
    }

    @Override
    public Optional<Muscle> findById(Long id) {
        return muscleRepository.findById(id);
    }

    @Override
    public Optional<Muscle> findByName(String name) {
        return muscleRepository.findByName(name);
    }
}
