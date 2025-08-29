/*package com.books.library.reposotories;

import com.books.library.TestDataUtil;
import com.books.library.doa.AuthorDoa;
import com.books.library.doa.impl.BookDoaimpl;
import com.books.library.domain.Author;
import com.books.library.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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

    @Test
    public void testThatBooksCanBeUpdated()
    {
        Author author = TestDataUtil.createTestAuthorA();
        authorDoa.create(author);

        Book bookA = TestDataUtil.createTestBookA();
        bookA.setAuthorId(author.getId());
        underTest.create(bookA);

        bookA.setTitle("Updated");
        underTest.update(bookA.getIsbn(), bookA);
        Optional<Book> result = underTest.findOne(bookA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookA);

    }

    @Test
    public void testThatBookCanBeDeleted()
    {
        Author author = TestDataUtil.createTestAuthorA();
        authorDoa.create(author);

        Book bookA = TestDataUtil.createTestBookA();
        bookA.setAuthorId(author.getId());
        underTest.create(bookA);

        underTest.delete(bookA.getIsbn());
        Optional<Book> result = underTest.findOne(bookA.getIsbn());
        assertThat(result).isEmpty();
    }

}*/
