package com.pwoogi.jpa.bookmanager.domain;

import com.pwoogi.jpa.bookmanager.repository.MemberHistoryRepository;
import com.pwoogi.jpa.bookmanager.support.BeanUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class MemberEntityListener {

    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o){

        MemberHistoryRepository memberHistoryRepository = BeanUtils.getBean(MemberHistoryRepository.class);

        Member member = (Member) o;

        MemberHistory memberHistory = new MemberHistory();
        memberHistory.setMemberId(member.getId());
        memberHistory.setName(member.getName());
        memberHistory.setEmail(member.getEmail());

        memberHistoryRepository.save(memberHistory);

    }

}
