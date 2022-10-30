package edu.ptit.wp2022.repositories;

import edu.ptit.wp2022.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findBookByCode(int code);

    void deleteByCode(int code);
}
