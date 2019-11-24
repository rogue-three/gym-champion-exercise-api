package com.roguethree.gymchampionexerciseap.restcontrollers;

import com.roguethree.gymchampionexerciseap.model.BodyPart;
import com.roguethree.gymchampionexerciseap.services.BodyPartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/bodyparts")
public class BodyPartController implements CrudRestController<BodyPart, Long>{

    private final BodyPartService bodyPartService;

    public BodyPartController(BodyPartService bodyPartService) {
        this.bodyPartService = bodyPartService;
    }

    @Override
    @GetMapping
    public ResponseEntity<Set<BodyPart>> getAll() {
        Set<BodyPart> bodyParts = bodyPartService.findAll().collect(Collectors.toSet());
        return ResponseEntity.ok().body(bodyParts);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<BodyPart> getById(Long id) {
        return bodyPartService.findById(id)
                .map(bodyOfResource -> ResponseEntity.ok().body(bodyOfResource))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<BodyPart> getByName(String name) {
        return bodyPartService.findByName(name.toLowerCase())
                .map(bodyPartResource -> ResponseEntity.ok().body(bodyPartResource))
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
