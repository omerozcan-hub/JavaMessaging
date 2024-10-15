package com.example.GraphQL.resolver;

import com.example.GraphQL.model.Book;
import com.example.GraphQL.model.Author;
import com.example.GraphQL.repository.AuthorRepository;
import com.example.GraphQL.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookResolver {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;


    @QueryMapping
    List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @QueryMapping
    Book getBook(@Argument Long id){
        return bookRepository.findById(id).orElseThrow(()->new RuntimeException("book not found!"));
    }

    @MutationMapping
    Boolean deleteBookById(@Argument Long id){
        bookRepository.deleteById(id);
        return true;
    }

    @MutationMapping
    Book addBook(@Argument String title,@Argument String publisher,@Argument Long authorId){

        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));

        Book book = new Book();
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setAuthor(author);

        return bookRepository.save(book);
    }
}
