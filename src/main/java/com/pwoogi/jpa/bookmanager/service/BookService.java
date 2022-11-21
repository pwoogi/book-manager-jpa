package com.pwoogi.jpa.bookmanager.service;

import com.pwoogi.jpa.bookmanager.domain.Author;
import com.pwoogi.jpa.bookmanager.domain.Book;
import com.pwoogi.jpa.bookmanager.repository.AuthorRepository;
import com.pwoogi.jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public void putBookAndAuthor(){
        Book book = new Book();
        book.setName("JPA 복습하기");

        bookRepository.save(book);

        Author author = new Author();
        author.setName("park");

        authorRepository.save(author);

    }

}
