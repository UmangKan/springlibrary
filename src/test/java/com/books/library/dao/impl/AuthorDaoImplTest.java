package com.books.library.dao.impl;


import com.books.library.TestDataUtil;
import com.books.library.doa.impl.AuthorDoaimpl;
import com.books.library.domain.Author;
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
public class AuthorDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDoaimpl underTest;

    @Test
    public void testThatCreatesAuthorGeneratesCorrectSql()
    {
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("Umang"), eq(12)
                );
    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSQL()
    {
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age from authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDoaimpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }



}
