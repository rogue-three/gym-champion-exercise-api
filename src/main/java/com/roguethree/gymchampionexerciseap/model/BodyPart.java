package com.roguethree.gymchampionexerciseap.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "body_part")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")
public class BodyPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "body_part_id")
    private Long id;

    @Column(name = "body_part_name")
    private String name;

    @ManyToMany(mappedBy = "bodyParts")
    private Set<Exercise> exercises = new HashSet<>();

    public BodyPart(String name, Set<Exercise> exercises) {
        this.name = name;
        this.exercises = exercises;
    }

    public BodyPart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BodyPart bodyPart = (BodyPart) o;
//        return id.equals(bodyPart.id) &&
//                name.equals(bodyPart.name) &&
//                exercises.equals(bodyPart.exercises);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, exercises);
//    }
}
