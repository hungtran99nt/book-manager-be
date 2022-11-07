package edu.ptit.wp2022.services;

import edu.ptit.wp2022.models.Book;
import edu.ptit.wp2022.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServices {
    private final BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findBookById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        Book desBook = bookRepository.findBookById(book.getId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        desBook.setApproved(book.isApproved());
        desBook.setCategory(book.getCategory());
        desBook.setTitle(book.getTitle());
        desBook.setAuthor(book.getAuthor());

        return bookRepository.save(desBook);
    }

    @Transactional
    public void deleteBook(int id) {
        bookRepository.findBookById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));
        bookRepository.deleteById(id);
    }
}
