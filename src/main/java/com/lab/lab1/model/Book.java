package com.lab.lab1.model;

import com.lab.lab1.model.enums.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {
    public Book() {
    }
    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Category category;
    @ManyToOne
    private Author author;
    private Integer availableCopies;
}
