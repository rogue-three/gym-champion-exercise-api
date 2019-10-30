package com.roguethree.gymchampionexerciseap.restcontrollers;


import com.roguethree.gymchampionexerciseap.model.Exercise;
import com.roguethree.gymchampionexerciseap.model.Equipment;
import com.roguethree.gymchampionexerciseap.services.ExerciseService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/v1/exercises")
public class ExerciseController implements CrudRestController<Exercise, Long>{

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }


    @Override
    @GetMapping
    public ResponseEntity<Resources<Resource<Exercise>>> getAll() {
        Resources<Resource<Exercise>> resources = new Resources<>(
                exerciseService.findAll()
                        .map(this::changeToResource)
                        .collect(Collectors.toList())
        );
        return ResponseEntity.ok().body(resources);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Resource<Exercise>> getById(@PathVariable Long id) {
        return exerciseService.findById(id)
                .map(this::changeToResource)
                .map(bodyOfResource -> ResponseEntity.ok().body(bodyOfResource))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Resource<Exercise>> getByName(@PathVariable String name) {
        return exerciseService.findByName(name)
                .map(this::changeToResource)
                .map(bodyOfResource -> ResponseEntity.ok().body(bodyOfResource))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/equipment/{equipment}")
    @Transactional
    public ResponseEntity<Resources<Resource<Exercise>>> findByEquipment(@PathVariable String equipment){
        Resources<Resource<Exercise>> resources = new Resources<>(
                exerciseService.findByEquipmentName(equipment)
                .map(this::changeToResource)
                .collect(Collectors.toList())
        );
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/bodypart/{bodyPart}")
    @Transactional
    public ResponseEntity<Resources<Resource<Exercise>>> getExercisesByBodyPart(
            @PathVariable("bodyPart") String bodyPart){
        Resources<Resource<Exercise>> resources = new Resources<>(
                exerciseService.findByBodyPartName(bodyPart)
                        .map(this::changeToResource)
                        .collect(Collectors.toList())
        );
        resources.add(linkTo(methodOn(ExerciseController.class)
            .getExercisesByBodyPart(bodyPart)).withRel("byBodyPart"));
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/muscle/{muscleName}")
    @Transactional
    public ResponseEntity<Resources<Resource<Exercise>>> getExercisesByMuscle(
            @PathVariable("muscleName") String muscleName){
        Resources<Resource<Exercise>> resources = new Resources<>(
                exerciseService.findByMuscleName(muscleName)
                .map(this::changeToResource)
                .collect(Collectors.toList())
        );
        resources.add(linkTo(methodOn(ExerciseController.class)
        .getExercisesByMuscle(muscleName)).withRel("byMuscleName"));
        return ResponseEntity.ok().body(resources);
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


    private Resource<Exercise> changeToResource(Exercise exercise){
        Resource<Exercise> exerciseResource = new Resource<>(exercise);
        exerciseResource.add(linkTo(methodOn(ExerciseController.class)
                .getById(exercise.getId()))
                .withSelfRel());
        return exerciseResource;
    }
}
