package com.roguethree.gymchampionexerciseap.restcontrollers;

import com.roguethree.gymchampionexerciseap.model.PushPullScheme;
import com.roguethree.gymchampionexerciseap.services.PushPullSchemeService;
import org.springframework.http.ResponseEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class PushPullSchemeController implements CrudRestController<PushPullScheme, Long> {

    private final PushPullSchemeService ppService;

    public PushPullSchemeController(PushPullSchemeService ppService) {
        this.ppService = ppService;
    }

    @Override
    public ResponseEntity<Set<PushPullScheme>> getAll() {
        Set<PushPullScheme> pushPullSchemes = ppService.findAll().collect(Collectors.toSet());
        return ResponseEntity.ok(pushPullSchemes);
    }

    @Override
    public ResponseEntity<PushPullScheme> getById(Long id) {
        return ppService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<PushPullScheme> getByName(String name) {
        return ppService.findByName(name)
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
