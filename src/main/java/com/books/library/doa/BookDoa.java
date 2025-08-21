package com.books.library.doa;

import com.books.library.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDoa {
    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> find();
}
