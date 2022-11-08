package edu.ptit.wp2022.controllers;

import edu.ptit.wp2022.models.Book;
import edu.ptit.wp2022.services.BookServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BooksRestController {
    private final BookServices bookServices;

    public BooksRestController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookServices.getAllBooks();
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookServices.addBook(book);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return bookServices.updateBook(book);
    }

    @DeleteMapping("/delete/{code}")
    public void updateBook(@PathVariable String code) {
        bookServices.deleteBook(Integer.parseInt(code));
    }

    @GetMapping("/{code}/exist")
    public void existsBookByCode(@PathVariable(value = "code") String code) {
        bookServices.existsBookByCode(code);
    }
}




