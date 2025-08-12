package com.books.library.doa;

import com.books.library.domain.Book;

import java.util.Optional;

public interface BookDoa {
    void create(Book book);

    Optional<Book> find(String isbn);
}
