package com.roguethree.gymchampionexerciseap.restcontrollers;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

public interface CrudRestController<T, ID> {

    @GetMapping
    ResponseEntity<Set<T>> getAll();

    @GetMapping(value = "/id/{id}")
    ResponseEntity<T> getById(@PathVariable ID id);

    @GetMapping(value = "/name/{name}")
    ResponseEntity<T> getByName(@PathVariable String name);

    @PostMapping
    ResponseEntity<?> add();

    @DeleteMapping
    ResponseEntity<?> remove();

    @PutMapping
    ResponseEntity<?> replace();

    @PatchMapping
    ResponseEntity<?> update();


}
