package com.books.library;

import com.books.library.domain.Author;
import com.books.library.domain.Book;

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

    public static Book createTestBook() {
        return Book.builder()
                .isbn("978")
                .title("The boy Who lived")
                .authorId(1L)
                .build();
    }
}
