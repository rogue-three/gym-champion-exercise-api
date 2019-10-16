package com.roguethree.gymchampionexerciseap.restcontrollers;

import com.roguethree.gymchampionexerciseap.model.BodyPart;
import com.roguethree.gymchampionexerciseap.services.BodyPartService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "api/v1/bodyparts")
public class BodyPartController implements CrudRestController<BodyPart, Long>{

    private final BodyPartService bodyPartService;

    public BodyPartController(BodyPartService bodyPartService) {
        this.bodyPartService = bodyPartService;
    }


    @Override
    public ResponseEntity<Resources<Resource<BodyPart>>> getAll() {
        Resources<Resource<BodyPart>> resources = new Resources<>(
                bodyPartService.findAll()
                .map(this::changeToResource)
                .collect(Collectors.toList())
        );
        return ResponseEntity.ok().body(resources);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<Resource<BodyPart>> getById(Long id) {
        return bodyPartService.findById(id)
                .map(this::changeToResource)
                .map(bodyOfResource -> ResponseEntity.ok().body(bodyOfResource))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Resource<BodyPart>> getByName(String name) {
        return bodyPartService.findByName(name.toLowerCase())
                .map(this::changeToResource)
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

    private Resource<BodyPart> changeToResource(BodyPart bodyPart){
        Resource<BodyPart> bodyPartResource = new Resource<>(bodyPart);
        bodyPartResource.add(linkTo(methodOn(BodyPartController.class)
            .getById(bodyPart.getId()))
            .withSelfRel());
        return bodyPartResource;
    }

}
