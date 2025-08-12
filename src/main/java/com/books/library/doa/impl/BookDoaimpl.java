package com.books.library.doa.impl;

import com.books.library.doa.BookDoa;
import com.books.library.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookDoaimpl implements BookDoa {
    private final JdbcTemplate jdbcTemplate;

    public BookDoaimpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update(
                "INSERT INTO books (isbn, title, author_Id) VALUES (?, ?, ?)",
                book.getIsbn(), book.getTitle(), book.getAuthorId()
        );

    }

    @Override
    public Optional<Book> find(String isbn) {
        List<Book> results = jdbcTemplate.query("SELECT isbn, title, authorId from books where isbn = ? LIMIT = 1",
                new BookRowMapper(), isbn);
        return results.stream().findFirst();

    }

    public static class BookRowMapper implements RowMapper<Book>
    {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("title"))
                    .authorId(rs.getLong("authorId"))
                    .build();
        }
    }
}
