package com.kyobo.backend.dto.book.register;


import com.kyobo.backend.entity.Book;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookRequestRegisterDto {
    private String name;
    private int price;
    private String writer;

    public Book toEntity() {
        return new Book(name, writer, price);
    }
}