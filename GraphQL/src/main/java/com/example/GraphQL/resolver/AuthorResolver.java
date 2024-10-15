package com.example.GraphQL.resolver;

import com.example.GraphQL.model.Author;
import com.example.GraphQL.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorResolver {

    @Autowired
    private AuthorRepository authorRepository;

    @QueryMapping
    List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @MutationMapping
    Boolean deleteAuthorById(Long id){
        authorRepository.deleteById(id);
        return true;
    }

    @MutationMapping
    Author addAuthor(String name, int age){
        Author author = new Author();
        author.setName(name);
        author.setAge(age);

        return authorRepository.save(author);
    }

}
