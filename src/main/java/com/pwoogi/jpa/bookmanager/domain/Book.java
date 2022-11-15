package com.pwoogi.jpa.bookmanager.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(value = AuditingEntityListener.class)
@NoArgsConstructor
@Data
public class Book implements Auditable{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

//    @PrePersist
//    public void prePersist(){
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//
//    }
//
//    @PostUpdate
//    public void postUpdate(){
//        this.updatedAt = LocalDateTime.now();
//
//    }
}
