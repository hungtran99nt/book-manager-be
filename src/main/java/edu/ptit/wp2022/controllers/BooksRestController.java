package edu.ptit.wp2022.controllers;

import edu.ptit.wp2022.common.RestApi;
import edu.ptit.wp2022.dto.book.CreateBookRequestDto;
import edu.ptit.wp2022.dto.book.EditBookRequestDto;
import edu.ptit.wp2022.dto.book.ListBooksRequestDto;
import edu.ptit.wp2022.models.Book;
import edu.ptit.wp2022.services.BookServices;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(RestApi.Book.MAIN)
public class BooksRestController {
    private final BookServices bookServices;

    public BooksRestController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping()
    public Page<Book> getAllBooks(@ModelAttribute @Valid ListBooksRequestDto requestDto) {
        return bookServices.getBooks(requestDto);
    }

    @GetMapping("/{id}" + RestApi.Common.DETAIL)
    public Book getBookById(@PathVariable String id) {
        return bookServices.getBookById(Integer.parseInt(id));
    }

    @PostMapping(RestApi.Common.CREATE)
    public Book addBook(@RequestBody @Valid CreateBookRequestDto requestDto) {
        return bookServices.addBook(requestDto);
    }

    @PutMapping(RestApi.Common.EDIT)
    public Book updateBook(@RequestBody @Valid EditBookRequestDto requestDto) {
        return bookServices.updateBook(requestDto);
    }

    @DeleteMapping("/{id}" + RestApi.Common.DELETE)
    public void updateBook(@PathVariable String id) {
        bookServices.deleteBook(Integer.parseInt(id));
    }
}




