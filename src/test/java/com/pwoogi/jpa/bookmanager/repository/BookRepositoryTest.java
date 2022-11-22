package com.pwoogi.jpa.bookmanager.repository;

import com.pwoogi.jpa.bookmanager.domain.Book;
import com.pwoogi.jpa.bookmanager.domain.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    void bookTest(){
        Book book = new Book();
        book.setName("Happy Pwoogi");
        book.setAuthorId(1L);
//        book.setPublisher();
        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookCascadeTest(){
        Book book = new Book();
        book.setName("JPA 복습 CASCADE");

        Publisher publisher = new Publisher();
        publisher.setName("복습창고");

        book.setPublisher(publisher);
        bookRepository.save(book);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publisher : " + publisherRepository.findAll());

        Book book1 = bookRepository.findById(1L).get();
        System.out.println("---------" + book1 + "------------");
        book1.getPublisher().setName("예습창고");

        bookRepository.save(book1);
        System.out.println("Publisher : " + publisherRepository.findAll());

    }

    @Test
    void softDelete(){
        bookRepository.findAll().forEach(System.out::println);
        System.out.println(bookRepository.findById(3L));

//        bookRepository.findByCategoryIsNull().forEach(System.out::println);
//        bookRepository.findAllByDeletedFalse().forEach(System.out::println);
//        bookRepository.findByCategoryIsNullAndDeletedFalse().forEach(System.out::println);
    }

    @Test
    void queryTest(){

        bookRepository.findAll().forEach(System.out::println);

        System.out.println("findByNameRecently : " + bookRepository.findByNameRecently(
                "JPA 복습해보자",
                LocalDateTime.now().minusDays(1L),
                LocalDateTime.now().minusDays(1L)));

        System.out.println(bookRepository.findBookNameAndCategory());

        bookRepository.findBookNameAndCategory().forEach(b -> {
            System.out.println(b.getName() + " : " + b.getCategory());
        });

        bookRepository.findBookNameAndCategory(PageRequest.of(1,10)).forEach(bookNameAndCategory -> {
            System.out.println(bookNameAndCategory.getName() + " : " + bookNameAndCategory.getCategory());

        });
        bookRepository.findBookNameAndCategory(PageRequest.of(0,10)).forEach(bookNameAndCategory -> {
            System.out.println(bookNameAndCategory.getName() + " : " + bookNameAndCategory.getCategory());

        });
    }

}