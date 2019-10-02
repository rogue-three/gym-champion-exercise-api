package com.roguethree.gymchampionexerciseap.repository;

import com.roguethree.gymchampionexerciseap.model.BodyPart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BodyPartRepository extends CrudRepository<BodyPart, Long> {

    Optional<BodyPart> findByName(String name);
}
