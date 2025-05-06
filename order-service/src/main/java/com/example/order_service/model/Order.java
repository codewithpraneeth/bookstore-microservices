package com.example.order_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;


@Document(collection = "orders")
@Data
    public class Order {
        @Id
        private String id;
        private String bookId;
        private int quantity;
        private String status; // e.g., PENDING, CONFIRMED, CANCELLED
}

