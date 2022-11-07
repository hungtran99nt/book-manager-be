package edu.ptit.wp2022.mapper;

import edu.ptit.wp2022.dto.BookDto;
import edu.ptit.wp2022.models.Book;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {
    Book bookDtoToBook(BookDto bookDto);

    BookDto bookToBookDto(Book book);

    @BeanMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    Book updateBookFromBookDto(BookDto bookDto, @MappingTarget Book book);
}
