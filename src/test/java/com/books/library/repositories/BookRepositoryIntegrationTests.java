package com.books.library.repositories;

import com.books.library.TestDataUtil;
import com.books.library.domain.Author;
import com.books.library.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
public class BookRepositoryIntegrationTests {


    private BookRepository underTest;

    @Autowired
    private BookRepositoryIntegrationTests(BookRepository underTest)
    {
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled()
    {
        Author author = TestDataUtil.createTestAuthorA();
        Book book = TestDataUtil.createTestBookA(author);
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get().getIsbn()).isEqualTo(book.getIsbn());
        assertThat(result.get().getTitle()).isEqualTo(book.getTitle());
        assertThat(result.get().getAuthor().getName()).isEqualTo(book.getAuthor().getName());
        assertThat(result.get().getAuthor().getAge()).isEqualTo(book.getAuthor().getAge());

    }

    @Test
    public void testThatMultipleBooksCanBeGeneratedAndRecalled()
    {
        Author author = TestDataUtil.createTestAuthorA();

        Book bookA = TestDataUtil.createTestBookA(author);
        Book savedBookA = underTest.save(bookA); // Capture the returned object

        Book bookB = TestDataUtil.createTestBookB(author);
        Book savedBookB = underTest.save(bookB); // Capture the returned object

        Book bookC = TestDataUtil.createTestBookC(author);
        Book savedBookC = underTest.save(bookC); // Capture the returned object

        Iterable<Book> results = underTest.findAll();
        assertThat(results).
                hasSize(3).
                containsExactly(savedBookA, savedBookB, savedBookC); // Use the saved objects
    }

    @Test
    public void testThatBooksCanBeUpdated()
    {
        Author author = TestDataUtil.createTestAuthorA();

        Book bookA = TestDataUtil.createTestBookA(author);
        underTest.save(bookA);

        bookA.setTitle("Updated");
        Book savedBook = underTest.save(bookA);
        Optional<Book> result = underTest.findById(bookA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(savedBook);

    }

    @Test
    public void testThatBookCanBeDeleted()
    {
        Author author = TestDataUtil.createTestAuthorA();

        Book bookA = TestDataUtil.createTestBookA(author);
        underTest.save(bookA);

        underTest.deleteById(bookA.getIsbn());
        Optional<Book> result = underTest.findById(bookA.getIsbn());
        assertThat(result).isEmpty();
    }

}
