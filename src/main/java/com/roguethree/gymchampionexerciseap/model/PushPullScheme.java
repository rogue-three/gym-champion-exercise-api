package com.roguethree.gymchampionexerciseap.model;

import javax.persistence.*;

@Entity
public class PushPullScheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_p_scheme_id")
    private Long id;

    @Column(name = "p_p_scheme_name")
    private String ppSchemeName;

    public PushPullScheme() {
    }

    public PushPullScheme(String ppSchemeName) {
        this.ppSchemeName = ppSchemeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPpSchemeName() {
        return ppSchemeName;
    }

    public void setPpSchemeName(String ppSchemeName) {
        this.ppSchemeName = ppSchemeName;
    }

    @Override
    public String toString() {
        return "PushPullScheme{" +
                "id=" + id +
                ", ppSchemeName='" + ppSchemeName + '\'' +
                '}';
    }
}
