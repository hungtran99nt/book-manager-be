package edu.ptit.wp2022.services;

import edu.ptit.wp2022.dto.book.CreateBookRequestDto;
import edu.ptit.wp2022.dto.book.EditBookRequestDto;
import edu.ptit.wp2022.dto.book.ListBooksRequestDto;
import edu.ptit.wp2022.models.Book;
import edu.ptit.wp2022.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class BookServices {

    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;

    public BookServices(ModelMapper modelMapper, BookRepository bookRepository) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
    }

    public Page<Book> getBooks(ListBooksRequestDto requestDto) {
        return bookRepository.findAll(PageRequest.of(requestDto.getPage(), requestDto.getPageSize()));
    }

    public Book getBookById(int id) {
        Book book = bookRepository.findBookById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return modelMapper.map(book, Book.class);
    }

    public Book addBook(CreateBookRequestDto requestDto) {
        Book newBook = modelMapper.map(requestDto, Book.class);
        return bookRepository.save(newBook);
    }

    public Book updateBook(EditBookRequestDto requestDto) {
        bookRepository.findBookById(requestDto.getId())
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Book editedBook = modelMapper.map(requestDto, Book.class);
        return bookRepository.save(editedBook);
    }

    @Transactional
    public void deleteBook(int id) {
        bookRepository.findBookById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));
        bookRepository.deleteById(id);
    }
}
