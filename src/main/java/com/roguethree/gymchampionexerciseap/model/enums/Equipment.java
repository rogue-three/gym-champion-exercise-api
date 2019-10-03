package com.roguethree.gymchampionexerciseap.model.enums;

public enum Equipment {
    BARBELL("barbell"),
    DUMBBELL("dumbell"),
    KETTLEBELL("kattlebell"),
    MACHINE("machine");

    private String equipmentName;

    Equipment(String name){
        this.equipmentName = name;
    }

    public String getEquipmentName(){
        return this.equipmentName;
    }
}
