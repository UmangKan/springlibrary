package com.books.library.dao.impl;

import com.books.library.TestDataUtil;
import com.books.library.doa.impl.BookDoaimpl;
import com.books.library.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDoaImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDoaimpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql()
    {
        Book book = TestDataUtil.createTestBook();
        underTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_Id) VALUES (?, ?, ?)"),
                eq("978"), eq("The boy Who lived"), eq(1L)
        );
    }

    @Test
    public void testThatFindOneBookGeneratesCorrectSql()
    {
        underTest.find("978");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, authorId from books where isbn = ? LIMIT = 1"),
                ArgumentMatchers.<BookDoaimpl.BookRowMapper>any(),
                eq("978")

        );
    }


}
