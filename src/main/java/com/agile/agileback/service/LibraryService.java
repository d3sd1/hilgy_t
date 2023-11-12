package com.agile.agileback.service;

import com.agile.agileback.exception.BookAlreadyExistsException;
import com.agile.agileback.exception.BookLendException;
import com.agile.agileback.exception.BookNotFoundException;
import com.agile.agileback.model.Book;
import com.agile.agileback.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    private final BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book add(Book book) throws BookAlreadyExistsException {
        if (this.bookRepository.findById(book.getId()).isPresent()) {
            throw new BookAlreadyExistsException(String.format("Book with id %d already exists", book.getId()));
        }
        return this.bookRepository.save(book);
    }

    public void remove(long id) throws BookNotFoundException, BookLendException {
        Optional<Book> bookOpt = this.bookRepository.findById(id);
        if (bookOpt.isEmpty()) {
            throw new BookNotFoundException(String.format("Book with id %d not found", id));
        } else if (bookOpt.get().isAvailability()) {
            throw new BookLendException(String.format("Book with id %d is lent and not available.", id));
        }
        this.bookRepository.deleteById(id);
    }

    public List<Book> searchByTitle(String title) {
        return this.bookRepository.findAllByTitle(title);
    }

    public List<Book> searchByAuthor(String author) {
        return this.bookRepository.findAllByAuthor(author);
    }

    public List<Book> searchByIsbn(String isbn) {
        return this.bookRepository.findAllByIsbn(isbn);
    }

    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    public Book getById(long id) throws BookNotFoundException {
        Optional<Book> bookOpt = this.bookRepository.findById(id);
        if (bookOpt.isEmpty()) {
            throw new BookNotFoundException(String.format("Book with id %d not found", id));
        }
        return bookOpt.get();
    }
}
