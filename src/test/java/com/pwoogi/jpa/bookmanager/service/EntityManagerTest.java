package com.pwoogi.jpa.bookmanager.service;

import com.pwoogi.jpa.bookmanager.domain.Member;
import com.pwoogi.jpa.bookmanager.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void entityManagerTest(){
        System.out.println(entityManager.createQuery("select m from Member m").getResultList());

    }

    @Test
    void cacheFindTest(){
//        System.out.println(memberRepository.findById(1L).get());
//        System.out.println(memberRepository.findById(1L).get());
//        System.out.println(memberRepository.findById(1L).get());

        memberRepository.deleteById(1L);

    }
    @Test
    void cacheFindTest2(){
        Member member = memberRepository.findById(3L).get();
        member.setName("chrrisssss");
        memberRepository.save(member);

        System.out.println("-------------------");

        member.setEmail("chhhhhhhhange@gmail.com");
        memberRepository.save(member);


        System.out.println(memberRepository.findAll());
    }
}
