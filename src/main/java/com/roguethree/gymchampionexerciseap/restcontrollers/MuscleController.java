package com.roguethree.gymchampionexerciseap.restcontrollers;


import com.roguethree.gymchampionexerciseap.model.Muscle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "api/v1/muscle")
public class MuscleController implements CrudRestController<Muscle, Long> {



    @Override
    public ResponseEntity<Set<Muscle>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<Muscle> getById(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Muscle> getByName(String name) {
        return null;
    }

    @Override
    public ResponseEntity<?> add() {
        return null;
    }

    @Override
    public ResponseEntity<?> remove() {
        return null;
    }

    @Override
    public ResponseEntity<?> replace() {
        return null;
    }

    @Override
    public ResponseEntity<?> update() {
        return null;
    }
}
