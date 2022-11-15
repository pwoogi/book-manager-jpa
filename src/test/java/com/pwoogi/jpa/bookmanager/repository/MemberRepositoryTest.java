package com.pwoogi.jpa.bookmanager.repository;

import com.pwoogi.jpa.bookmanager.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void crud(){
        Member member1 = new Member("jack", "jack@gmail.com");
        Member member2 = new Member("chris", "chris@gmail.com");
        Member member3 = new Member("david", "david@gmail.com");
        Member member4 = new Member("belle", "belle@gmail.com");
        Member member5 = new Member("park", "park@gmail.com");
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        memberRepository.save(member5);

        List<Member> members = memberRepository.findAll();

        members.forEach(System.out::println);

        Page<Member> memberList = memberRepository.findAll(PageRequest.of(0,3));
        System.out.println("page : " + memberList);
        System.out.println("total : " + memberList.getTotalElements());
        System.out.println("totalPages : " + memberList.getTotalPages());
        System.out.println("numberOfElement : " + memberList.getNumberOfElements());
        System.out.println("sort : " + memberList.getSort());

    }
    @Test
    void example(){

        Member member1 = new Member("jack", "jack@gmail.com");
        memberRepository.save(member1);


        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());
        Example<Member> example = Example.of(new Member("ja", "gmail.com"), matcher);

        memberRepository.findAll(example).forEach(System.out::println);

    }

}