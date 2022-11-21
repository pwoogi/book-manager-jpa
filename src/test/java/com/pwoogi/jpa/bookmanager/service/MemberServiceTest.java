package com.pwoogi.jpa.bookmanager.service;

import com.pwoogi.jpa.bookmanager.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void test(){
        memberService.put();
        System.out.println(">>>> " + memberRepository.findByEmail("newMember@gmail.com"));

    }

}