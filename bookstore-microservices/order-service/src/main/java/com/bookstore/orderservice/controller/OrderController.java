package com.bookstore.orderservice.controller;

import com.bookstore.orderservice.model.Order;
import com.bookstore.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder(@RequestParam Long bookId,
                            @RequestParam Integer quantity) {

        return orderService.placeOrder(bookId, quantity);
    }
}