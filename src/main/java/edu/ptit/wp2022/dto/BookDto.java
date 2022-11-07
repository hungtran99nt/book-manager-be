package edu.ptit.wp2022.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link edu.ptit.wp2022.models.Book} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements Serializable {
    private int id;
    private String code;
    private String title;
    private String author;
    private String category;
    private boolean approved;
}