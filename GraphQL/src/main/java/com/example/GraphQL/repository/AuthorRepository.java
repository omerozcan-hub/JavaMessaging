package com.example.GraphQL.repository;

import com.example.GraphQL.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
