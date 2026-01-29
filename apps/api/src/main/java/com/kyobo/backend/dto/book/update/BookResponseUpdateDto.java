package com.kyobo.backend.dto.book.update;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookResponseUpdateDto {
    private String name;
    private int price;
    private String writer;
}