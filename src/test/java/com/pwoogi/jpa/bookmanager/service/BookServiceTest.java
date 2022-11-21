package com.pwoogi.jpa.bookmanager.service;

import com.pwoogi.jpa.bookmanager.repository.AuthorRepository;
import com.pwoogi.jpa.bookmanager.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void transactionTest(){
        bookService.putBookAndAuthor();
        System.out.println("book : " + bookRepository.findAll());
        System.out.println("author : " + authorRepository.findAll());

    }

}