package com.roguethree.gymchampionexerciseap.restcontrollers;

import com.roguethree.gymchampionexerciseap.model.BodyPart;
import com.roguethree.gymchampionexerciseap.services.BodyPartService;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "api/v1/bodyparts")
public class BodyPartController {

    private final BodyPartService bodyPartService;

    public BodyPartController(BodyPartService bodyPartService) {
        this.bodyPartService = bodyPartService;
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Resource<BodyPart>> getBodyPartById(@PathVariable("id") Long id){
        return bodyPartService.findById(id)
                .map(this::changeToResource)
                .map(bodyOfResource -> ResponseEntity.ok().body(bodyOfResource))
                .orElse(ResponseEntity.notFound().build());
    }

    // TODO
    @PostMapping
    public ResponseEntity<?> addBodyPart(){
        return null;
    }

    // TODO
    @DeleteMapping
    public ResponseEntity<?> removeBodyPart(){
        return null;
    }

    // TODO
    @PutMapping
    public ResponseEntity<?> replaceBodyPart(){
        return null;
    }

    // TODO
    @PatchMapping
    public ResponseEntity<?> updateBodyPart(){
        return null;
    }




    private Resource<BodyPart> changeToResource(BodyPart bodyPart){
        Resource<BodyPart> bodyPartResource = new Resource<>(bodyPart);
        bodyPartResource.add(linkTo(methodOn(BodyPartController.class)
            .getBodyPartById(bodyPart.getId()))
            .withSelfRel());
        return bodyPartResource;
    }
}
