package com.kyobo.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String writer;

    private int price;

    public Book(
            String title,
            String writer,
            int price) {
        this.title = title;
        this.writer = writer;
        this.price = price;
    }

    public void updateTitle(String newTitle) {
        this.title = newTitle;
    }

    public void updateWriter(String newWriter) {
        this.writer = newWriter;
    }

    public void updatePrice(int newPrice) {
        this.price = newPrice;
    }
}
