package com.lab.lab1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Author {
    public Author() {
    }
    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;
}
