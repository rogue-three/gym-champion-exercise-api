package com.roguethree.gymchampionexerciseap.services;

import java.util.Optional;
import java.util.stream.Stream;

public interface CrudService<T, ID> {

    Stream<T> findAll();
    Optional<T> findById(ID id);
    Optional<T> findByName(String name);
}
