package com.example.book_service.controller;

import com.example.book_service.model.Book;
import com.example.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



    @RestController
    @RequestMapping("/api/books")
    public class BookController {

        @Autowired
        private BookService bookService;

        @PostMapping
        public Book createBook(@RequestBody Book book) {
            return bookService.createBook(book);
        }

        @GetMapping
        public List<Book> getAllBooks() {
            return bookService.getAllBooks();
        }

        @GetMapping("/{id}")
        public Book getBookById(@PathVariable String id) {
            return bookService.getBookById(id);
        }

        @DeleteMapping("/{id}")
        public void deleteBook(@PathVariable String id) {
            bookService.deleteBook(id);
        }
    }

