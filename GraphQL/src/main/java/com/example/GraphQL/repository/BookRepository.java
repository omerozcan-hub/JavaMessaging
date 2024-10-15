package com.example.GraphQL.repository;

import com.example.GraphQL.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
