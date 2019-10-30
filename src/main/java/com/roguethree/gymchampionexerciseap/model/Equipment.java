package com.roguethree.gymchampionexerciseap.model;

import javax.persistence.*;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Long id;

    @Column(name = "equipment_name")
    private String equipmentName;

    public Equipment(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Equipment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", equipmentName='" + equipmentName + '\'' +
                '}';
    }
}
