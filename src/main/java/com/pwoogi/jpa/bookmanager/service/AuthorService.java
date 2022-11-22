package com.pwoogi.jpa.bookmanager.service;

import com.pwoogi.jpa.bookmanager.domain.Author;
import com.pwoogi.jpa.bookmanager.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void putAuthor(){

        Author author = new Author();
        author.setName("chris");

        authorRepository.save(author);

        throw new RuntimeException("오류가 발생하였고 transaction 상태를 확인해 봅시다.");


    }
}
