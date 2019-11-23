package com.roguethree.gymchampionexerciseap.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exercise_name")
    private String name;


    @OneToOne
    @JoinColumn(name = "equipment", referencedColumnName = "equipment_id")
    private Equipment equipment;

    @OneToOne
    @JoinColumn(name = "body_position", referencedColumnName = "body_position_id")
    private BodyPosition bodyPosition;


    @OneToOne
    @JoinColumn(name = "p_p_scheme", referencedColumnName = "p_p_scheme_id")
    private PushPullScheme pushPullScheme;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "exercise_to_body_part",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "body_part_id"))
    @JsonManagedReference
    private Set<BodyPart> bodyParts = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "exercise_to_muscles",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_id"))
    @JsonManagedReference
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

}
