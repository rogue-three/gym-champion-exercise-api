package com.roguethree.gymchampionexerciseap.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.roguethree.gymchampionexerciseap.model.enums.BodyPosition;
import com.roguethree.gymchampionexerciseap.model.enums.Equipment;
import com.roguethree.gymchampionexerciseap.model.enums.PushPullScheme;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Equipment equipment;

    @Enumerated(value = EnumType.STRING)
    private BodyPosition bodyPosition;

    @Enumerated(value = EnumType.STRING)
    private PushPullScheme pushPullScheme;

    @ManyToMany
    @JoinTable(name = "exercise_to_body_part",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "body_part_id"))
    private Set<BodyPart> bodyParts = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "exercise_to_muscles",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_id"))
    private Set<Muscle> muscles = new HashSet<>();

    public Exercise(String name, Equipment equipment,
                    BodyPosition bodyPosition, PushPullScheme pushPullScheme,
                    Set<BodyPart> bodyParts, Set<Muscle> muscles) {
        this.name = name;
        this.equipment = equipment;
        this.bodyPosition = bodyPosition;
        this.pushPullScheme = pushPullScheme;
        this.bodyParts = bodyParts;
        this.muscles = muscles;
    }

    public Exercise() {
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

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public BodyPosition getBodyPosition() {
        return bodyPosition;
    }

    public void setBodyPosition(BodyPosition bodyPosition) {
        this.bodyPosition = bodyPosition;
    }

    public PushPullScheme getPushPullScheme() {
        return pushPullScheme;
    }

    public void setPushPullScheme(PushPullScheme pushPullScheme) {
        this.pushPullScheme = pushPullScheme;
    }

    public Set<BodyPart> getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(Set<BodyPart> bodyParts) {
        this.bodyParts = bodyParts;
    }

    public Set<Muscle> getMuscles() {
        return muscles;
    }

    public void setMuscles(Set<Muscle> muscles) {
        this.muscles = muscles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return id.equals(exercise.id) &&
                name.equals(exercise.name) &&
                equipment == exercise.equipment &&
                bodyPosition == exercise.bodyPosition &&
                pushPullScheme == exercise.pushPullScheme &&
                bodyParts.equals(exercise.bodyParts) &&
                muscles.equals(exercise.muscles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, equipment, bodyPosition, pushPullScheme, bodyParts, muscles);
    }
}
