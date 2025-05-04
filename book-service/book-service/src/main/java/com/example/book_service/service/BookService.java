package com.example.book_service.service;

import com.example.book_service.model.Book;
import com.example.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;



@Service
public class BookService {

        @Autowired
        private BookRepository bookRepository;

        public Book createBook(Book book) {
            book.setId(UUID.randomUUID().toString());
            return bookRepository.save(book);
        }

        public List<Book> getAllBooks() {
            return bookRepository.findAll();
        }

        public Book getBookById(String id) {
            return bookRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Book not found"));
        }

        public void deleteBook(String id) {
            bookRepository.deleteById(id);
        }

}
