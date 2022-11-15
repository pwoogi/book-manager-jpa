package com.pwoogi.jpa.bookmanager.repository;

import com.pwoogi.jpa.bookmanager.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

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
    @Test
    void updateCrud(){
        memberRepository.save(new Member("david","david@gmail.com"));

        Member m = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        m.setEmail("park@gmail.com");
        System.out.println(m);

    }
    @Test
    void select(){
        System.out.println(memberRepository.findByName("david"));

    }

    @Test
    void pagingAndSortingTest(){

        Member m1 = new Member("jack","jack@gmail.com");
        Member m2 = new Member("chris","chris@gmail.com");
        Member m3 = new Member("jackson","jackson@gmail.com");
        Member m4 = new Member("jackie","jackie@gmail.com");
        Member m5 = new Member("jack","jack@naver.com");

        memberRepository.save(m1);
        memberRepository.save(m2);
        memberRepository.save(m3);
        memberRepository.save(m4);
        memberRepository.save(m5);


        System.out.println("findFirstByName : " + memberRepository.findFirstByName("jack", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("findByName : " + memberRepository.findByName("jack", PageRequest.of(1,1, Sort.by(Sort.Order.desc("id")))).getTotalElements());
    }
}