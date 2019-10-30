package com.roguethree.gymchampionexerciseap.restcontrollers;

import com.roguethree.gymchampionexerciseap.model.Equipment;
import com.roguethree.gymchampionexerciseap.services.EquipmentService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class EquipmentController implements CrudRestController<Equipment, Long> {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Override
    public ResponseEntity<Resources<Resource<Equipment>>> getAll() {


        return null;
    }

    @Override
    public ResponseEntity<Resource<Equipment>> getById(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Resource<Equipment>> getByName(String name) {
        return null;
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
