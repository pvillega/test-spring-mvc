package com.perevillega.eia.model;

import javax.persistence.*;


@Entity
@Table(name = "userTable")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 32, unique = true)
    private String name;


    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

