package com.example.SpringData_JPA.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String isbn;
    private String publisher;

    // Hibernate requires a constructor without arguments to instantiate a class.
    // When we write a class, if we don't put a constructor for it, Java itself does this by default,
    // but as soon as we define a constructor with variables, it doesn't consider the constructor without arguments for us, and we have to define it.
    public Book() {
    }

    public Book(String name, String isbn, String publisher) {
        this.name = name;
        this.isbn = isbn;
        this.publisher = publisher;
    }

}
