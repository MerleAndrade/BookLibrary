package com.example.booklibrary.controller;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getallBooks();
    }

    @GetMapping("{isbn}")
    public Book getBookByIsbn(
            @PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    @PostMapping
    public Book addBook(
            @RequestBody Book newBook) {
        return bookService.addBook(newBook);
    }

    @DeleteMapping("{isbn}")
    public void deleteBook(
            @PathVariable String isbn) {
        bookService.deleteBook(isbn);
    }
}
