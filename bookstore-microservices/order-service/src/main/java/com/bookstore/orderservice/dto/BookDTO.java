package com.bookstore.orderservice.dto;

import lombok.Data;

@Data
public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Double price;
    private Integer quantity;
    private String category;

}