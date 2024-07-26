package com.example.SpringData_JPA;

import com.example.SpringData_JPA.domain.Book;
import com.example.SpringData_JPA.repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

// @DataJpaTest is one of the annotations in Spring Boot that is used for tests related to JPA (Java Persistence API).
// This annotation is specifically designed for JPA repository testing and control.
// Data layer only configuration: Loads only JPA-related beans and repositories into the Spring Context.
// In other words, only those parts of the application that are related to data access (data access) are loaded and configured.
// Set an in-memory database (in-memory database): By default, it uses an in-memory database such as H2,
// HSQL, or Derby. This makes tests run faster and doesn't require a database.
// Automatic text setting for repositories: All JPA repositories and settings are automatically set and used.
// This means that there is no need to manually adjust these components.
// Disabling unnecessary services: Services that are required for repositories testing
// (such as web services and security services) are disabled to run faster and more accurately.
// Execution of tests in a transaction: Each method is executed in a transaction by default.
// At the end of each test, the transaction is automatically rolled back, so the changes applied by the tests will reach the main database.
// Transactional Test Support: By default, each test is executed in a separate transaction,
// and at the end of the test, it is rolled back so that the database returns to its original state.

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpringBootJpaTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    @Commit
    @Order(1)
    //@Rollback(value = false) == @Commit
    void testJpaTestSplice() {
        long countBefore= bookRepository.count();
        Assertions.assertThat(countBefore).isEqualTo(0);

        bookRepository.save(new Book("My Book","130","RandomHouse"));

        long countAfter = bookRepository.count();

        Assertions.assertThat(countBefore).isLessThan(countAfter);
    }

    @Test
    @Order(2)
    void testJpaTestSpliceTransaction() {
        long countBefore= bookRepository.count();
        Assertions.assertThat(countBefore).isEqualTo(1);
    }

}
