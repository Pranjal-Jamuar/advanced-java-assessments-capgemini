package com.bookstore.orderservice.client;

import com.bookstore.orderservice.dto.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service")
public interface BookClient {

    @GetMapping("/api/books/{id}")
    BookDTO getBookById(@PathVariable Long id);

}