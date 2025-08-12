package com.books.library.dao.impl;

import com.books.library.TestDataUtil;
import com.books.library.doa.impl.BookDoaimpl;
import com.books.library.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTests {

    private BookDoaimpl underTest;

    @Autowired
    private BookDaoImplIntegrationTests (BookDoaimpl underTest)
    {
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled()
    {
        Book book = TestDataUtil.createTestBook();
        underTest.create(book);
        Optional<Book> result = underTest.find(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);

    }
}
