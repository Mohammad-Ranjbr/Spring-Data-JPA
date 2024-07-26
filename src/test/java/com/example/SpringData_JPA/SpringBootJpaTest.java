package com.example.SpringData_JPA;

import com.example.SpringData_JPA.domain.Book;
import com.example.SpringData_JPA.repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class SpringBootJpaTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testJpaTestSplice() {
        long countBefore= bookRepository.count();

        bookRepository.save(new Book("My Book","130","RandomHouse"));

        long countAfter = bookRepository.count();

        Assertions.assertThat(countBefore).isLessThan(countAfter);
    }

}
