package com.roguethree.gymchampionexerciseap.restcontrollers;

import com.roguethree.gymchampionexerciseap.model.Equipment;
import com.roguethree.gymchampionexerciseap.services.EquipmentService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/equipment")
public class EquipmentController implements CrudRestController<Equipment, Long> {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Override
    @GetMapping
    public ResponseEntity<Set<Equipment>> getAll() {
        Set<Equipment> equipment = equipmentService.findAll().collect(Collectors.toSet());
        return ResponseEntity.ok().body(equipment);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Equipment> getById(@PathVariable Long id) {
        return equipmentService.findById(id)
                .map(equipment -> ResponseEntity.ok().body(equipment))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Equipment> getByName(@PathVariable String name) {
        return equipmentService.findByName(name)
                .map(equipment -> ResponseEntity.ok().body(equipment))
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

    private Resource<Equipment> changeToResource(Equipment equipment){

        return new Resource<>(equipment);
    }
}
