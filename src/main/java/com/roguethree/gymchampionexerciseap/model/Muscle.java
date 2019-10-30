package com.roguethree.gymchampionexerciseap.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "muscle")
public class Muscle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "muscle_id")
    private Long id;

    @Column(name = "muscle_name")
    private String name;

    @ManyToMany(mappedBy = "muscles")
    @JsonBackReference
    private Set<Exercise> exercises = new HashSet<>();

    public Muscle(String name, Set<Exercise> exercises) {
        this.name = name;
        this.exercises = exercises;
    }

    public Muscle() {
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
}
