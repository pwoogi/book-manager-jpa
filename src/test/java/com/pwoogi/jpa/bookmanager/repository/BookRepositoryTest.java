package com.pwoogi.jpa.bookmanager.repository;

import com.pwoogi.jpa.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest(){
        Book book = new Book();
        book.setName("Happy Pwoogi");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

}