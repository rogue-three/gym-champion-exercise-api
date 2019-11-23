package com.roguethree.gymchampionexerciseap.restcontrollers;


import com.roguethree.gymchampionexerciseap.model.Exercise;
import com.roguethree.gymchampionexerciseap.services.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/exercises")
public class ExerciseController implements CrudRestController<Exercise, Long>{

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @CrossOrigin
    @Override
    @GetMapping
    public ResponseEntity<Set<Exercise>> getAll(){
        Set<Exercise> exerciseList =  exerciseService.findAll().collect(Collectors.toSet());
        return ResponseEntity.ok().body(exerciseList);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Exercise> getById(@PathVariable Long id){
        return exerciseService.findById(id)
                .map(exercise -> ResponseEntity.ok().body(exercise))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Exercise> getByName(@PathVariable String name) {
        return exerciseService.findByName(name)
                .map(exerciseOptional -> ResponseEntity.ok().body(exerciseOptional))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/equipment/{equipment}")
    @Transactional
    public ResponseEntity<Set<Exercise>> findByEquipment(@PathVariable String equipment){
        Set<Exercise> exercises = exerciseService.findByEquipmentName(equipment).collect(Collectors.toSet());
        return ResponseEntity.ok().body(exercises);
    }

    @GetMapping(value = "/bodypart/{bodyPart}")
    @Transactional
    public ResponseEntity<Set<Exercise>> getExercisesByBodyPart(
            @PathVariable("bodyPart") String bodyPart){
        Set<Exercise> exercises = exerciseService.findByBodyPartName(bodyPart).collect(Collectors.toSet());
        return ResponseEntity.ok().body(exercises);
    }

    @GetMapping(value = "/muscle/{muscleName}")
    @Transactional
    public ResponseEntity<Set<Exercise>> getExercisesByMuscle(
            @PathVariable("muscleName") String muscleName){
        Set<Exercise> exercises = exerciseService.findByMuscleName(muscleName).collect(Collectors.toSet());
        return ResponseEntity.ok().body(exercises);
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
