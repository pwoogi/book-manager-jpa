package com.pwoogi.jpa.bookmanager.service;

import com.pwoogi.jpa.bookmanager.domain.Member;
import com.pwoogi.jpa.bookmanager.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final EntityManager entityManager;
    @Transactional
    public void put(){
        Member member = new Member();
        member.setName("newMember");
        member.setEmail("newMember.gmail.com");

        entityManager.persist(member);
        entityManager.flush();
        entityManager.detach(member);
        member.setName("newMemberAfterPersist");

        entityManager.merge(member);
    }
}
