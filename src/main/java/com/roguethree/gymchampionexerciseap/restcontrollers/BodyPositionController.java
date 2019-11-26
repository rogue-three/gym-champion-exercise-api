package com.roguethree.gymchampionexerciseap.restcontrollers;

import com.roguethree.gymchampionexerciseap.model.BodyPosition;
import com.roguethree.gymchampionexerciseap.services.BodyPositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/bodypositions")
public class BodyPositionController implements CrudRestController<BodyPosition, Long>{

    private final BodyPositionService bodyPositionService;

    public BodyPositionController(BodyPositionService bodyPositionService) {
        this.bodyPositionService = bodyPositionService;
    }

    @Override
    @GetMapping
    public ResponseEntity<Set<BodyPosition>> getAll() {
        Set<BodyPosition> bodyPositions = bodyPositionService.findAll().collect(Collectors.toSet());
        return ResponseEntity.ok(bodyPositions);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<BodyPosition> getById(@PathVariable Long id) {
        return bodyPositionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<BodyPosition> getByName(@PathVariable String name) {
        return bodyPositionService.findByName(name.toLowerCase())
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
