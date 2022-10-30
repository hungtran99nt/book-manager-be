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

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        Book desBook = bookRepository.findBookByCode(book.getCode())
                .orElseThrow(() -> new NoSuchElementException("Book not found"));

        desBook.setApproved(book.getApproved());
        desBook.setCategory(book.getCategory());
        desBook.setTitle(book.getTitle());
        desBook.setAuthor(book.getAuthor());

        return bookRepository.save(desBook);
    }

    @Transactional
    public void deleteBook(int code) {
        bookRepository.findBookByCode(code)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));
        bookRepository.deleteByCode(code);
    }
}
