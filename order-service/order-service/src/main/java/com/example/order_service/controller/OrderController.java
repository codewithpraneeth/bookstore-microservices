package com.example.order_service.controller;

import com.example.order_service.model.Order;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/orders")
public class OrderController {

        @Autowired
        private OrderService orderService;

        @PostMapping
        public Order createOrder(@RequestBody Order order) {
            return orderService.createOrder(order);
        }

        @GetMapping
        public List<Order> getAllOrders() {
            return orderService.getAllOrders();
        }

        @GetMapping("/{id}")
        public Order getOrderById(@PathVariable String id) {
            return orderService.getOrderById(id);
        }

        @PutMapping("/{id}/cancel")
        public void cancelOrder(@PathVariable String id) {
            orderService.cancelOrder(id);
        }
}

