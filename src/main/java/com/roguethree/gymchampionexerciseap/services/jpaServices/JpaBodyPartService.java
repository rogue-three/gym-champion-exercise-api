package com.roguethree.gymchampionexerciseap.services.jpaServices;

import com.roguethree.gymchampionexerciseap.model.BodyPart;
import com.roguethree.gymchampionexerciseap.repository.BodyPartRepository;
import com.roguethree.gymchampionexerciseap.services.BodyPartService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class JpaBodyPartService implements BodyPartService {

    private final BodyPartRepository bodyPartRepository;

    public JpaBodyPartService(BodyPartRepository bodyPartRepository) {
        this.bodyPartRepository = bodyPartRepository;
    }

    @Override
    public Stream<BodyPart> findAll() {
        Iterable<BodyPart> iterable = bodyPartRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    @Override
    public Optional<BodyPart> findById(Long id) {
        return bodyPartRepository.findById(id);
    }

    @Override
    public Optional<BodyPart> findByName(String name) {
        return bodyPartRepository.findByName(name);
    }
}
