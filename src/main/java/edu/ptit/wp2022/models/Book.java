package edu.ptit.wp2022.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "code", length = 10, unique = true)
    private String code;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "author", length = 50)
    private String author;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "approved", nullable = false)
    private boolean approved;
}
