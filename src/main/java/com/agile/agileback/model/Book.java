package com.agile.agileback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title",
            nullable = false)
    private String title;

    @Column(name = "author",
            nullable = true)
    private String author;

    @Column(name = "isbn",
            unique = true)
    private String isbn;

    @Column(name = "availability")
    private boolean availability = false;

}
