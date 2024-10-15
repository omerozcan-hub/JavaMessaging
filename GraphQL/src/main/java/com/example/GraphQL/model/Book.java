package com.example.GraphQL.model;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String publisher;

    @ManyToOne
    private Author author;

    // Getter ve Setter'lar
}
