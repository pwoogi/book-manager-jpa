package com.pwoogi.jpa.bookmanager.repository;

import com.pwoogi.jpa.bookmanager.domain.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long> {
}
