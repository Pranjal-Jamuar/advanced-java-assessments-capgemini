package com.bookstore.orderservice.service;

import com.bookstore.orderservice.client.BookClient;
import com.bookstore.orderservice.dto.BookDTO;
import com.bookstore.orderservice.model.Order;
import com.bookstore.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookClient bookClient;

    public OrderService(OrderRepository orderRepository, BookClient bookClient) {
        this.orderRepository = orderRepository;
        this.bookClient = bookClient;
    }

    public Order placeOrder(Long bookId, Integer quantity) {

        BookDTO book = bookClient.getBookById(bookId);

        double totalPrice = book.getPrice() * quantity;

        Order order = new Order();
        order.setBookId(bookId);
        order.setQuantity(quantity);
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }
}