package edu.ptit.wp2022.controllers;

import edu.ptit.wp2022.models.Book;
import edu.ptit.wp2022.services.BookServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v2/books")
public class BooksController {
    private final BookServices bookServices;

    public BooksController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping()
    public String getAllBooks(Model model) {
        List<Book> books = bookServices.getAllBooks();
        model.addAttribute("books", books);
        return "book_pages/index";
    }

    @GetMapping("/add")
    public String showFormCreate(Model model) {
        Book newBook = new Book();
        model.addAttribute("newBook", newBook);
        return "book_pages/create";
    }

    @PostMapping("/add")
    public String createBook(@ModelAttribute("book") Book book) {
        Book newBook = bookServices.addBook(book);
        System.out.println(newBook);
        return "redirect:/v2/books";
    }

    @GetMapping("/{id}/view")
    public String showFormEdit(Model model, @PathVariable(value = "id") int id) {
        Book book = bookServices.getBookById(id);
        model.addAttribute("book", book);
        return "book_pages/view";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookServices.updateBook(book);
        return "redirect:/v2/books";
    }

    @GetMapping("/{id}/delete")
    public String deleteBook(@PathVariable(value = "id") int id) {
        bookServices.deleteBook(id);
        return "redirect:/v2/books";
    }

    @GetMapping("/{code}/exist")
    public void existsBookByCode(@PathVariable(value = "code") String code) {
        bookServices.existsBookByCode(code);
    }
}
