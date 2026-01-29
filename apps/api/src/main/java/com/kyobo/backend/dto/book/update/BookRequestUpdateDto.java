package com.kyobo.backend.dto.book.update;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookRequestUpdateDto {
    private Long id;
    private String name;
    private int price;
    private String writer;
}