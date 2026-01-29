package com.kyobo.backend.service;

import com.kyobo.backend.dto.book.BookDto;
import com.kyobo.backend.dto.book.register.BookRequestRegisterDto;
import com.kyobo.backend.dto.book.update.BookRequestUpdateDto;

import java.util.List;

public interface BookService {

    BookDto registerBook(BookRequestRegisterDto bookRequestRegisterDto);

    BookDto updateBook(BookRequestUpdateDto bookRequestUpdateDto);

    List<BookDto> getBookList(Integer pageNumber, Integer size, String sortBy, String order);

    BookDto findById(Long id);
}
