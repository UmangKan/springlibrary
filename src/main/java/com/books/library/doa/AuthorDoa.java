package com.books.library.doa;

import com.books.library.domain.Author;

import java.util.Optional;

public interface AuthorDoa {
    void create(Author author);

    public Optional<Author> findOne(long l);
}


