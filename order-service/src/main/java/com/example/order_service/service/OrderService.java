package com.example.order_service.service;

import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

    @Service
    public class OrderService {

        @Autowired
        private OrderRepository orderRepository;

        @Autowired
        private KafkaTemplate<String, String> kafkaTemplate;

        @Autowired
        private RestTemplate restTemplate;

        @Value("${book-service.url}")
        private String bookServiceUrl;

        public Order createOrder(Order order) {
            // Validate book exists
            String bookUrl = bookServiceUrl + "/" + order.getBookId();
            try {
                restTemplate.getForObject(bookUrl, Object.class);
            } catch (Exception e) {
                throw new RuntimeException("Book not found");
            }

            // Create order
            order.setId(UUID.randomUUID().toString());
            order.setStatus("CONFIRMED");
            orderRepository.save(order);

            // Send Kafka event
            kafkaTemplate.send("order-events", order.getId(), "Order created for book: " + order.getBookId());

            return order;
        }

        public List<Order> getAllOrders() {
            return orderRepository.findAll();
        }

        public Order getOrderById(String id) {
            return orderRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Order not found"));
        }

        public void cancelOrder(String id) {
            Order order = getOrderById(id);
            order.setStatus("CANCELLED");
            orderRepository.save(order);
        }
    }

