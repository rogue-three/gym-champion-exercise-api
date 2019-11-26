package com.roguethree.gymchampionexerciseap.services.jpaServices;

import com.roguethree.gymchampionexerciseap.model.BodyPosition;
import com.roguethree.gymchampionexerciseap.repository.BodyPositionRepository;
import com.roguethree.gymchampionexerciseap.services.BodyPositionService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class JpaBodyPositionService implements BodyPositionService{

    private final BodyPositionRepository bodyPositionRepository;

    public JpaBodyPositionService(BodyPositionRepository bodyPositionRepository) {
        this.bodyPositionRepository = bodyPositionRepository;
    }

    @Override
    public Stream<BodyPosition> findAll() {
        Iterable<BodyPosition> bodyPositions = bodyPositionRepository.findAll();
        return StreamSupport.stream(bodyPositions.spliterator(), false);
    }

    @Override
    public Optional<BodyPosition> findById(Long id) {
        return bodyPositionRepository.findById(id);
    }

    @Override
    public Optional<BodyPosition> findByName(String name) {
        return bodyPositionRepository.findByBodyPositionName(name);
    }
}
