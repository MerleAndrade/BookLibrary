package com.example.booklibrary.model;

public record Book(String isbn, String title, String author, BookType type) {
}
