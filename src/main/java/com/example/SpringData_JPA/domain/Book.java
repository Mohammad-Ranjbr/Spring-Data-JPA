package com.example.SpringData_JPA.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
public class Book {

    // GenerationType.AUTO - Let Hibernate Pick - best practice is to specify -> This strategy automatically selects
    // the best strategy for ID generation based on the database type. For example, in databases such as MySQL, IDENTITY may be used,
    // and in databases such as Oracle, SEQUENCE may be used. This strategy is usually used when JPA wants to choose the best strategy.
    // GenerationType.SEQUENCE - Use database sequence (Not a feature of MySQL , feature of Oracle) -> This strategy uses sequences to generate identifiers.
    // Sequences in databases are mechanisms used to automatically generate unique values for identifiers (IDs) or other sequential values.
    // GenerationType.IDENTITY - Use auto-incremented database columns -> This strategy uses auto-increment columns in the database to generate identifiers.
    // Suitable for databases such as MySQL and PostgreSQL that support auto-increment.
    // GenerationType.TABLE - Use database table to simulate sequence -> This strategy uses a table in the database to generate identifiers.
    // This table holds the values of the identifiers and is updated to generate new identifiers.
    // Perfect for when you don't want to depend on auto-increment sequences or columns.

    // GenerationType.IDENTITY and GenerationType.SEQUENCE are generally better performing than GenerationType.TABLE.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private String publisher;
    private Long authorId;

    // Hibernate requires a constructor without arguments to instantiate a class.
    // When we write a class, if we don't put a constructor for it, Java itself does this by default,
    // but as soon as we define a constructor with variables, it doesn't consider the constructor without arguments for us, and we have to define it.
    public Book() {
    }

    public Book(String title, String isbn, String publisher,Long authorId) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authorId = authorId;
    }

    // The equals and hashCode functions in Java are important for comparing objects and using them in specific data structures such as HashSet and HashMap.
    // equals function - > Purpose: To compare two objects to determine whether they are logically equal.
    // Default: The default implementation of the equals function in the Object class deals with reference comparison,
    // reference comparison means comparing the memory addresses of objects. This type of comparison checks whether two objects point to the exact same reference in memory.
    // Custom implementation: To compare the contents of objects, you must implement the equals function in your classes.
    // Usually, this implementation involves comparing the values of important fields of objects.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    // hashCode function -> Purpose: To generate a numeric hash value for the object that is used for faster lookups and comparisons.
    // Default: The default implementation of the hashCode function in the Object class usually works by object reference.
    // Custom implementation: If you implement the equals function in your class,
    // you must also implement the hashCode function to ensure that equal objects (based on equals) have the same hash values.
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Hibernate needs the equals and hashCode functions because of how it manages and maintains objects in the database and
    // also to optimize performance in various operations. Here are some of the main reasons why Hibernate needs these functions:
    // 1. Caching management -> Hibernate uses cache to temporarily store and manage database objects.
    // In order for Hibernate to properly manage objects in the cache and avoid re-caching duplicate data,
    // it needs to identify objects by their values. For this purpose, the equals function is used
    // to compare objects and the hashCode function is used to create the hash value.
    // Comparing objects: Hibernate uses the equals function to determine whether an object exists in the cache or not.
    // If two objects are logically equal (based on the implementation of the equals function), Hibernate can identify one as the cached version.
    // Creating a hash value: The hashCode function is used to group cache objects.
    // A hash value helps Hibernate quickly search and manage objects in data structures such as HashSet and HashMap.
    // 2. Collections management -> When interacting with collections of database objects, such as Set or Map,
    // Hibernate needs to use the equals and hashCode functions in order to properly manage the objects in these collections.
    // Collections: In collections such as HashSet or HashMap, the equals and hashCode functions are used to
    // compare objects and avoid storing duplicate values. Hibernate needs to properly manage objects in these structures.
    // 3. Synchronizing the status of objects -> When objects are loaded from the database or changes to objects are saved,
    // Hibernate must use the equals and hashCode functions to compare the state of the objects and update the database.
    // Change detection: To detect changes to objects and database updates, Hibernate depends on the
    // equals and hashCode functions to ensure that changes are correctly detected and handled.

    // Numeric Hash Value in programming refers to an integer that is used to uniquely represent an object or data.
    // This number is typically generated by the hashCode function and is used to optimize searches and compare data in specific data structures.
    // Uses of numeric hash value
    // Cache management (Caching): -> Hash value helps data structures like HashSet or HashMap to search and manage objects faster.
    // Using a hash value allows these structures to group and retrieve objects based on their hash value.
    // Search operation: -> In data structures built on hashes (such as HashMap or HashTable),
    // the hash value is used to find where to store the object in memory. This makes searching and accessing objects faster.
    // Compare objects: -> A hash value helps reduce the number of direct comparisons between objects.
    // Instead of completely comparing the content, it can be faster to compare the hash value,
    // and if the hash value is different, it is easy to conclude that the objects are different.
    // How to generate a numeric hash value
    // The hashCode function in Java is used to generate a numeric hash value. This function must be
    // implemented in such a way that it produces the same hash value for equal objects (according to the equals function).
    // A proper implementation of hashCode ensures that logically equal objects are handled correctly.

}
