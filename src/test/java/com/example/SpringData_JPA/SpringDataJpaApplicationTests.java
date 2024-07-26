package com.example.SpringData_JPA;

import com.example.SpringData_JPA.repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	void testBookRepository() {
		// Using the count method of bookRepository, it gets the total number of records in the books table.
		long count = bookRepository.count();
		Assertions.assertThat(count).isGreaterThan(0);
	}

	@Test
	void contextLoads() {
	}

}
