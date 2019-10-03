package com.roguethree.gymchampionexerciseap.services;

import com.roguethree.gymchampionexerciseap.model.BodyPart;

import java.util.Optional;

public interface BodyPartService extends CrudService<BodyPart, Long> {

    Optional<BodyPart> findByName(String name);
}
