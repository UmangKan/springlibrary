package com.books.library;

import com.books.library.domain.Author;
import com.books.library.domain.Book;

public final class TestDataUtil {
    private TestDataUtil (){

    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .name("Umang")
                .age(12)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .name("Jk")
                .age(40)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .name("Ryan")
                .age(70)
                .build();
    }

    public static Book createTestBookA(final Author author) {
        return Book.builder()
                .isbn("978")
                .title("The boy Who lived")
                .author(author)
                .build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder()
                .isbn("123")
                .title("Olympus")
                .author(author)
                .build();
    }

    public static Book createTestBookC(final Author author) {
        return Book.builder()
                .isbn("678")
                .title("ramayan")
                .author(author)
                .build();
    }
}
