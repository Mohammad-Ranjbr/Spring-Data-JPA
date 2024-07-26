package com.example.SpringData_JPA;

import com.example.SpringData_JPA.repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

// Even though we used @ActiveProfile, we still can't connect to mysql
// because the default ُSpring Boot for testing the database is h2 , and it overrides mysql with h2,
// we have to tell it not to replace it.
// The @AutoConfigureTestDatabase annotation is used in Spring Boot
// to configure the database when running tests. Specifically,
// the parameter replace = AutoConfigureTestDatabase.Replace.NONE states that
// Spring Boot should not replace the default configured database with an in-memory database.
// By default, when you use Spring Boot tests,
// Spring Boot tries to substitute an in-memory database (such as H2, HSQL, or Derby)
// to run the tests. This is done so that the tests run faster and are independent of the actual database.
// However, in some cases, you want to run your tests against a real database (like MySQL, PostgreSQL, etc.).
@DataJpaTest
@ActiveProfiles("local") // It goes to read the application.properties file, because we used h2 database, but now we want to check the connection of mysql.
@ComponentScan(basePackages = {"com.example.SpringData_JPA.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testMySQL() {
        long countBefore= bookRepository.count();
        Assertions.assertThat(countBefore).isEqualTo(2);
    }

}
