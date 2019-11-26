package com.roguethree.gymchampionexerciseap.restcontrollers;

import com.roguethree.gymchampionexerciseap.model.Muscle;
import com.roguethree.gymchampionexerciseap.services.MuscleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/muscle")
public class MuscleController implements CrudRestController<Muscle, Long> {

    private final MuscleService muscleService;

    public MuscleController(MuscleService muscleService) {
        this.muscleService = muscleService;
    }

    @Override
    @GetMapping
    public ResponseEntity<Set<Muscle>> getAll() {
        Set<Muscle> muscles = muscleService.findAll().collect(Collectors.toSet());
        return ResponseEntity.ok().body(muscles);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Muscle> getById(@PathVariable Long id) {
        return muscleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Muscle> getByName(@PathVariable String name) {
        return muscleService.findByName(name.toLowerCase())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
