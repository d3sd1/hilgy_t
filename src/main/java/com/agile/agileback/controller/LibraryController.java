package com.agile.agileback.controller;

import com.agile.agileback.controller.dto.BookDTO;
import com.agile.agileback.controller.mapper.BookMapper;
import com.agile.agileback.exception.BookAlreadyExistsException;
import com.agile.agileback.exception.BookLendException;
import com.agile.agileback.exception.BookNotFoundException;
import com.agile.agileback.model.Book;
import com.agile.agileback.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;
    private final BookMapper bookMapper;

    public LibraryController(LibraryService libraryService, BookMapper bookMapper) {
        this.libraryService = libraryService;
        this.bookMapper = bookMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getAll() {
        return new ResponseEntity<>(libraryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") long id) throws BookNotFoundException {
        return new ResponseEntity<>(libraryService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> getById(@RequestParam(name = "search_by") String searchBy, @RequestParam(name = "search_val") String searchVal) {
        return switch (searchBy.toLowerCase()) {
            case "title" -> new ResponseEntity<>(libraryService.searchByTitle(searchVal), HttpStatus.OK);
            case "isbn" -> new ResponseEntity<>(libraryService.searchByIsbn(searchVal), HttpStatus.OK);
            case "author" -> new ResponseEntity<>(libraryService.searchByAuthor(searchVal), HttpStatus.OK);
            default -> throw new UnsupportedOperationException(String.format("Search by field %s not allowed", searchBy));
        };

    }

    @PostMapping("")
    public ResponseEntity<Book> create(@RequestBody BookDTO bookDTO) throws BookAlreadyExistsException {
        return new ResponseEntity<>(libraryService.add(bookMapper.bookDTOToBook(bookDTO)), HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) throws BookLendException, BookNotFoundException {
        libraryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
