package com.example.book_service.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;



@Entity
@Data
public class Book {
        @Id
        private String id;
        private String title;
        private String author;
        private double price;
    }

