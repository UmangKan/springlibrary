package com.books.library;

import com.books.library.domain.Author;

public final class TestDataUtil {
    private TestDataUtil (){

    }

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Umang")
                .age(12)
                .build();
    }
}
