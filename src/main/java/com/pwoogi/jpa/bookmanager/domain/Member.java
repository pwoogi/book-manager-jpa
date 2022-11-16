package com.pwoogi.jpa.bookmanager.domain;

import com.pwoogi.jpa.bookmanager.domain.listener.Auditable;
import com.pwoogi.jpa.bookmanager.domain.listener.MemberEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@EntityListeners(value = {AuditingEntityListener.class, MemberEntityListener.class})
//@Table(name = "member", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING) //ORDINAL default 값임, enum 변경될 때 변동 가능성이 있기때문에 STRING 타입을 권장
    private Gender gender;

//    @Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
////    @Column(insertable = false)
//    @LastModifiedDate
//    private LocalDateTime updatedAt;
//
//    @Transient //db 반영 x , obj 객체로 사용할 때
//    private String testData;

//    @PrePersist
//    public void prePersist(){
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//
//    }
//    @PostPersist
//    public void postPersist(){
//        System.out.println(">>> postPersist");
//
//    }
//
//    @PostUpdate
//    public void postUpdate(){
//        this.updatedAt = LocalDateTime.now();
//
//    }
//
//    @PreRemove
//    public void preRemove() {
//        System.out.println(">>> preRemove");
//    }
//
//    @PostRemove
//    public void postRemove(){
//        System.out.println(">>> postRemove");
//
//    }
//
//    @PostLoad
//    public void postLoad(){
//        System.out.println(">>> postLoad");
//
//    }
}
