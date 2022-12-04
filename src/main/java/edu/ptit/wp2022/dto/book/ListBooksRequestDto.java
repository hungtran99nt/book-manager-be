package edu.ptit.wp2022.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListBooksRequestDto {
    private boolean isFetchAll = false;
    private int page = 1;
    private int pageSize = 10;

    private int pageBegin = page * pageSize + 1;
    private int pageEnd = page * pageSize + pageSize;
}
