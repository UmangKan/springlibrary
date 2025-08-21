package com.books.library.dao.impl;

import com.books.library.TestDataUtil;
import com.books.library.doa.AuthorDoa;
import com.books.library.doa.impl.BookDoaimpl;
import com.books.library.domain.Author;
import com.books.library.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTests {

    private AuthorDoa authorDoa;
    private BookDoaimpl underTest;

    @Autowired
    private BookDaoImplIntegrationTests (BookDoaimpl underTest, AuthorDoa authorDoa)
    {
        this.underTest = underTest;
        this.authorDoa = authorDoa;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled()
    {
        Author author = TestDataUtil.createTestAuthorA();
        authorDoa.create(author);
        Book book = TestDataUtil.createTestBookA();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);

    }

    @Test
    public void testThatMultipleBooksCanBeGeneratedAndRecalled()
    {
        Author author = TestDataUtil.createTestAuthorA();

        authorDoa.create(author);
        Book bookA = TestDataUtil.createTestBookA();
        bookA.setAuthorId(author.getId());
        underTest.create(bookA);

        Book bookB = TestDataUtil.createTestBookB();
        bookB.setAuthorId(author.getId());
        underTest.create(bookB);

        Book bookC = TestDataUtil.createTestBookC();
        bookC.setAuthorId(author.getId());
        underTest.create(bookC);

        List<Book> results = underTest.find();
        assertThat(results).
                hasSize(3).
                containsExactly(bookA, bookB, bookC);
    }

}
