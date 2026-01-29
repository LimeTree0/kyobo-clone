package com.kyobo.backend.service;

import com.kyobo.backend.dto.book.BookDto;
import com.kyobo.backend.dto.book.register.BookRequestRegisterDto;
import com.kyobo.backend.dto.book.update.BookRequestUpdateDto;
import com.kyobo.backend.entity.Book;
import com.kyobo.backend.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Transactional
    @Override
    public BookDto registerBook(BookRequestRegisterDto bookRequestRegisterDto) {
        Book save = bookRepository.save(bookRequestRegisterDto.toEntity());

        return BookDto.from(save);
    }

    @Transactional
    @Override
    public BookDto updateBook(BookRequestUpdateDto bookRequestUpdateDto) {
        Book book = bookRepository.findById(bookRequestUpdateDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("아이디에 해당하는 정보를 찾을 수 없습니다."));

        book.updateTitle(bookRequestUpdateDto.getName());
        book.updateWriter(bookRequestUpdateDto.getWriter());
        book.updatePrice(bookRequestUpdateDto.getPrice());

        return BookDto.from(book);
    }

    @Override
    public List<BookDto> getBookList(
            Integer pageNumber,
            Integer size,
            String sortBy,
            String order
    ) {
        Sort.Direction sortDirection = getSortDirection(order);
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(sortDirection, sortBy));

        return bookRepository.findAll(pageable).stream()
                .map(book -> BookDto.from(book))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("아이디에 해당하는 정보를 찾을 수 없습니다."));

        return BookDto.from(book);
    }

    private Sort.Direction getSortDirection(String order) {
        return order.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

    }
}