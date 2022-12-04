package edu.ptit.wp2022.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditBookRequestDto {
    @NotNull
    @Max(value = Integer.MAX_VALUE)
    private int id;

    @NotNull
    @Size(max = 100)
    private String title;

    @NotNull
    @Size(max = 50)
    private String author;

    @Size(max = 50)
    private String category;

    @Size(max = 500)
    private String description;

    @NotNull
    private Date publishOn;

    @Max(value = 10000)
    private int totalPage;

    private String imagePath;
}
