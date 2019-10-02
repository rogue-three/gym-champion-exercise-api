package com.roguethree.gymchampionexerciseap.restcontrollers;


import com.roguethree.gymchampionexerciseap.model.Exercise;
import com.roguethree.gymchampionexerciseap.services.ExerciseService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/v1/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;


    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping(value = "/name/{name")
    public ResponseEntity<Resource<Exercise>> getExerciseByName(@PathVariable String name){
        return exerciseService.findByName(name)
                .map(this::changeToResource)
                .map(bodyOfResource -> ResponseEntity.ok().body(bodyOfResource))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Resource<Exercise>> getExercisesById(@PathVariable Long id){
        return exerciseService.findById(id)
                .map(this::changeToResource)
                .map(bodyOfResource -> ResponseEntity.ok().body(bodyOfResource))
                .orElse(ResponseEntity.notFound().build());
    }

    private Resource<Exercise> changeToResource(Exercise exercise){
        Resource<Exercise> exerciseResource = new Resource<>(exercise);

        exerciseResource.add(linkTo(methodOn(ExerciseController.class)
        .getExercisesById(exercise.getId()))
        .withSelfRel());
        return exerciseResource;
    }



}
