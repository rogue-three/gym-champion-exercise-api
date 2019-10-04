package com.roguethree.gymchampionexerciseap.restcontrollers;


import com.roguethree.gymchampionexerciseap.model.Exercise;
import com.roguethree.gymchampionexerciseap.services.ExerciseService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/v1/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public ResponseEntity<Resources<Resource<Exercise>>> getAllExercises(){
        Resources<Resource<Exercise>> resources = new Resources<>(
                exerciseService.findAll()
                    .map(this::changeToResource)
                    .collect(Collectors.toList())
        );
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Resource<Exercise>> getExerciseByName(@PathVariable String name){
        return exerciseService.findByName(name)
                .map(this::changeToResource)
                .map(bodyOfResource -> ResponseEntity.ok().body(bodyOfResource))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Resource<Exercise>> getExerciseById(@PathVariable Long id){
        return exerciseService.findById(id)
                .map(this::changeToResource)
                .map(bodyOfResource -> ResponseEntity.ok().body(bodyOfResource))
                .orElse(ResponseEntity.notFound().build());
    }

    // TODO - ask on stack what the hell is going on
//    @Transactional
//    @GetMapping(value = "/bodypart/{bodyPart}")
//    public ResponseEntity<Resources<Resource<Exercise>>> getExercisesByBodyPart(@PathVariable("bodyPart") String bodyPart){
//        System.out.println(exerciseService.findByBodyPartName(bodyPart).count());
//        System.out.println("////////////////////////////////" + exerciseService.findByBodyPartName(bodyPart).map(Exercise::getName));
//        Resources<Resource<Exercise>> resources = new Resources<>(
//                exerciseService.findByBodyPartName(bodyPart)
//                    .map(this::changeToResource)
//                    .collect(Collectors.toList())
//        );
////        resources.add(linkTo(methodOn(ExerciseController.class)
////            .getExercisesByBodyPart(bodyPart)).withRel("byBodyPart"));
//        return ResponseEntity.ok().body(resources);
//    }

    // TODO
    @PostMapping
    public ResponseEntity<?> addExercise(){
        return null;
    }

    // TODO
    @DeleteMapping
    public ResponseEntity<?> removeExercise(){
        return null;
    }

    // TODO
    @PutMapping
    public ResponseEntity<?> replaceExercise(){
        return null;
    }

    // TODO
    @PatchMapping
    public ResponseEntity<?> updateExercise(){
        return null;
    }


    private Resource<Exercise> changeToResource(Exercise exercise){
        Resource<Exercise> exerciseResource = new Resource<>(exercise);
        exerciseResource.add(linkTo(methodOn(ExerciseController.class)
        .getExerciseById(exercise.getId()))
        .withSelfRel());
        return exerciseResource;
    }


}
