package com.example.booklibrary.repository;
import com.example.booklibrary.model.Book;
import java.util.*;

public class BookRepository {

    Map<String, Book> books = new HashMap<>();

    public List<Book> getallBooks(){
        return new ArrayList<>(books.values());
    }

    public Optional<Book> getBookByIsbn(String isbn) {
        Optional<Book> bookOptional =Optional.ofNullable(books.get(isbn));
        return bookOptional;
    }

    public Book addBook(String isbn, Book newBook) {
        books.put(isbn, newBook);
        return newBook;
    }

    public void deleteBook(String isbn){
        books.remove(isbn);
    }




}
