package com.kyobo.backend.dto.book.register;

public record BookResponseRegisterDto (
        Long id,
        String name,
        int price,
        String writer
) {}