package com.example.SpringData_JPA.bootstrap;

import com.example.SpringData_JPA.domain.Book;
import com.example.SpringData_JPA.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"local","default"})
// @Profile({"local", "default"}) states that this class (or any other bean that has this annotation) is only enabled on images with local or default profiles.
// If the local or default profile is already active, Spring will load this configuration or bean into its context.
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Autowired
    public DataInitializer(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        bookRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design","123","RandomHouse");
        System.out.println("ID: " + bookDDD.getId());
        bookRepository.save(bookDDD);
        System.out.println("ID: " + bookDDD.getId());

        Book bookSIA = new Book("Spring In Action","124","RandomHouse");
        bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book ID: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
            System.out.println("Book Publisher: " + book.getPublisher());
        });
    }

}
