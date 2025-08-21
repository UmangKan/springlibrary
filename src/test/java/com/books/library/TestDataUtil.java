package com.books.library;

import com.books.library.domain.Author;
import com.books.library.domain.Book;

public final class TestDataUtil {
    private TestDataUtil (){

    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Umang")
                .age(12)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Jk")
                .age(40)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Ryan")
                .age(70)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("978")
                .title("The boy Who lived")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("123")
                .title("Olympus")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookC() {
        return Book.builder()
                .isbn("678")
                .title("ramayan")
                .authorId(1L)
                .build();
    }
}
