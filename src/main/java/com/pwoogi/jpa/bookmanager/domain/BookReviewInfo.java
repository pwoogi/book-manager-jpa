package com.pwoogi.jpa.bookmanager.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class BookReviewInfo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long bookId;

    @OneToOne(optional = false)
    private Book book;

    private float averageReviewScore;

    private int reviewCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookReviewInfo that = (BookReviewInfo) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
