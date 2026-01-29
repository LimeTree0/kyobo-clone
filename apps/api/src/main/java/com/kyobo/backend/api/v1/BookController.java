package com.kyobo.backend.api.v1;

import com.kyobo.backend.dto.book.BookDto;
import com.kyobo.backend.dto.book.register.BookRequestRegisterDto;
import com.kyobo.backend.dto.book.register.BookResponseRegisterDto;
import com.kyobo.backend.dto.book.update.BookRequestUpdateDto;
import com.kyobo.backend.dto.book.update.BookResponseUpdateDto;
import com.kyobo.backend.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;


    @PostMapping
    public BookResponseRegisterDto registerBook(@RequestBody BookRequestRegisterDto bookRequestRegisterDto) {
        log.info("registerBookRequestDto : {}", bookRequestRegisterDto);

        BookDto result = bookService.registerBook(bookRequestRegisterDto);

        log.info("saved result : {}", result);

        return new BookResponseRegisterDto(
                result.getId(),
                result.getTitle(),
                result.getPrice(),
                result.getWriter()
        );
    }

    @PutMapping
    public BookResponseUpdateDto updateBook(@RequestBody BookRequestUpdateDto bookRequestUpdateDto) {
        BookDto bookDto = bookService.updateBook(bookRequestUpdateDto);

        return new BookResponseUpdateDto(
                bookDto.getTitle(),
                bookDto.getPrice(),
                bookDto.getWriter()
        );
    }

    @GetMapping
    public List<BookDto> bookList(
            @RequestParam(required = false, defaultValue = "0", value = "page") Integer pageNumber,
            @RequestParam(required = false, defaultValue = "10", value = "size") Integer size,
            @RequestParam(required = false, defaultValue = "id", value = "sortBy") String sortBy,
            @RequestParam(required = false, defaultValue = "desc", value = "order") String order
    ) {

        log.info("page : {}, size : {}", pageNumber, size);

        return bookService.getBookList(pageNumber, size, sortBy, order);
    }

    @GetMapping("/{id}")
    public BookDto findBookById(@PathVariable Long id) {
        return bookService.findById(id);

    }
}