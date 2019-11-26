package com.roguethree.gymchampionexerciseap.restcontrollers;

import com.roguethree.gymchampionexerciseap.model.PushPullScheme;
import com.roguethree.gymchampionexerciseap.services.PushPullSchemeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/pushpullscheme")
public class PushPullSchemeController implements CrudRestController<PushPullScheme, Long> {

    private final PushPullSchemeService ppService;

    public PushPullSchemeController(PushPullSchemeService ppService) {
        this.ppService = ppService;
    }

    @Override
    @GetMapping
    public ResponseEntity<Set<PushPullScheme>> getAll() {
        Set<PushPullScheme> pushPullSchemes = ppService.findAll().collect(Collectors.toSet());
        return ResponseEntity.ok(pushPullSchemes);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<PushPullScheme> getById(Long id) {
        return ppService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<PushPullScheme> getByName(String name) {
        return ppService.findByName(name.toLowerCase())
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
