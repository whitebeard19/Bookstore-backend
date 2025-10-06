package com.bookstorelite.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private BigDecimal price;
    private Integer stock;
}
