package com.pwoogi.jpa.bookmanager.domain.listener;

import com.pwoogi.jpa.bookmanager.domain.Member;
import com.pwoogi.jpa.bookmanager.domain.MemberHistory;
import com.pwoogi.jpa.bookmanager.repository.MemberHistoryRepository;
import com.pwoogi.jpa.bookmanager.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class MemberEntityListener {

    @PostPersist
    @PostUpdate
    public void prePersistAndPreUpdate(Object o){

        MemberHistoryRepository memberHistoryRepository = BeanUtils.getBean(MemberHistoryRepository.class);

        Member member = (Member) o;

        MemberHistory memberHistory = new MemberHistory();
        memberHistory.setName(member.getName());
        memberHistory.setEmail(member.getEmail());
        memberHistory.setMember(member);

        memberHistoryRepository.save(memberHistory);


    }

}
