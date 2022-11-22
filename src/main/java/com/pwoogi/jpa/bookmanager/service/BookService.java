package com.pwoogi.jpa.bookmanager.service;

import com.pwoogi.jpa.bookmanager.domain.Author;
import com.pwoogi.jpa.bookmanager.domain.Book;
import com.pwoogi.jpa.bookmanager.repository.AuthorRepository;
import com.pwoogi.jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;
    private final EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    public void putBookAndAuthor(){
        Book book = new Book();
        book.setName("JPA 복습하기");

        bookRepository.save(book);

        try {
            authorService.putAuthor();
        }catch (RuntimeException e){

        }
//        Author author = new Author();
//        author.setName("park");
//
//        authorRepository.save(author);

//        throw new RuntimeException("오류가 발생하였고 transaction 상태를 확인해 봅시다.");


    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void get(Long id){
        System.out.println(">>>>> :"  + bookRepository.findById(id));
        System.out.println(">>>>> : " + bookRepository.findAll());

        entityManager.clear();

        System.out.println(">>>>> :"  + bookRepository.findById(id));
        System.out.println(">>>>> : " + bookRepository.findAll());

        bookRepository.update();

        entityManager.clear();

//        Book book = bookRepository.findById(id).get();
//        book.setName("바뀌려나?");
//        bookRepository.save(book);

    }

}
