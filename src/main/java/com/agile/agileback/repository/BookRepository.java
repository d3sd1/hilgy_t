package com.agile.agileback.repository;

import com.agile.agileback.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByTitle(String title);

    List<Book> findAllByAuthor(String author);

    List<Book> findAllByIsbn(String author);
}