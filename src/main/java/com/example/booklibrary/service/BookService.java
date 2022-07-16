package com.example.booklibrary.service;

import com.example.booklibrary.repository.BookRepository;
import com.example.booklibrary.model.Book;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getallBooks() {
        return bookRepository.getallBooks();
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.getBookByIsbn(isbn)
                .orElseThrow( () -> new NoSuchElementException("Book not found with isbn: " + isbn));
    }

    public Book addBook(Book newBook){
        return bookRepository.addBook(newBook.isbn(), newBook);
    }

    public void deleteBook(String isbn){
        Optional<Book> book = bookRepository.getBookByIsbn(isbn);

        if(book.isEmpty()){
            System.out.println("Book was not really, it didn't exist in the first place!");
        }else{
            bookRepository.deleteBook(isbn);
        }
    }
}
