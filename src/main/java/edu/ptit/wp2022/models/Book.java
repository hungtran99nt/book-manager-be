package edu.ptit.wp2022.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "author", length = 50, nullable = false)
    private String author;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "publishOn", nullable = false)
    private Date publishOn;

    @Column(name = "totalPage", nullable = false)
    private int totalPage;
}
