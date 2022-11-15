package com.pwoogi.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class MemberTest {

    @Test
    void test(){
        Member user = new Member();
        user.setEmail("martin@gmail.com");
        user.setName("martin");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        Member user1 = new Member(null, "martin", "martin@gmail.com", LocalDateTime.now(), LocalDateTime.now());
        Member user2 = new Member("martin", "martin@gmail.com");

        Member user3 = Member.builder()
                .name("martin")
                .email("martin@naver.com")
                .build();

        System.out.println(">>>> : " + user);
    }

}