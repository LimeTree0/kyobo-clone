package com.kyobo.backend.dto.book;


import com.kyobo.backend.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BookDto {
    private Long id;
    private String title;
    private String writer;
    private int price;

    public static BookDto from(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getWriter(),
                book.getPrice()
        );
    }
}
