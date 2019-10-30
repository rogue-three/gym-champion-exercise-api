package com.roguethree.gymchampionexerciseap.model;

import javax.persistence.*;

@Entity
public class BodyPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "body_position_id")
    private Long id;

    @Column(name = "body_position_name")
    private String bodyPositionName;

    public BodyPosition(String bodyPositionName) {
        this.bodyPositionName = bodyPositionName;
    }

    public BodyPosition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBodyPositionName() {
        return bodyPositionName;
    }

    public void setBodyPositionName(String bodyPositionName) {
        this.bodyPositionName = bodyPositionName;
    }

    @Override
    public String toString() {
        return "BodyPosition{" +
                "id=" + id +
                ", bodyPositionName='" + bodyPositionName + '\'' +
                '}';
    }
}
