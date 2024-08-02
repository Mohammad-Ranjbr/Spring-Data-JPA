package com.example.SpringData_JPA.repositories;

import com.example.SpringData_JPA.domain.AuthorUuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorUuidRepository extends JpaRepository<AuthorUuid, UUID> {
}