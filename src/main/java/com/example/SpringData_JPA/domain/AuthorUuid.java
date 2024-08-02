package com.example.SpringData_JPA.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
public class AuthorUuid {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36,columnDefinition = "BINARY(16)", updatable = false , nullable = false)
    private UUID id;
    private String firstName;
    private String lastName;

}
