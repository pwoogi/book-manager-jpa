package com.pwoogi.jpa.bookmanager.repository;

import com.pwoogi.jpa.bookmanager.domain.Book;
import com.pwoogi.jpa.bookmanager.dto.BookNameAndCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Query(value = "update book set category='none'", nativeQuery = true)
    void update();

    List<Book> findByCategoryIsNull();
    List<Book> findAllByDeletedFalse();

    List<Book> findByCategoryIsNullAndDeletedFalse();

    @Query(value = "select b from Book b "
        + "where name = :name and createdAt >= :createdAt and updatedAt >= :updatedAt and category is null")
    List<Book> findByNameRecently(
            @Param("name") String name,
            @Param("createdAt") LocalDateTime createdAt,
            @Param("updatedAt") LocalDateTime updatedAt);

    @Query(value = "select new com.pwoogi.jpa.bookmanager.dto.BookNameAndCategory(b.name, b.category) from Book b")
    // TODO : 조회해온 값을 생성자 파라미터에 넘겨줄 수 있음.
    List<BookNameAndCategory> findBookNameAndCategory();

    @Query(value = "select new com.pwoogi.jpa.bookmanager.dto.BookNameAndCategory(b.name, b.category) from Book b")
    Page<BookNameAndCategory> findBookNameAndCategory(Pageable pageable);

    @Query(value = "select * from book", nativeQuery = true)
    List<Book> findAllCustom();

    @Transactional //native query의 경우 트랜잭션을 직접 선언해줘야함
    @Modifying // dml에서 return되는 값이 적용된 로우 개수로 표시됨, 그래서 업데이트라는 것을 알려줘야하는 modifying 어노테이션 필요
    @Query(value = "update book set category = 'IT전문서적'", nativeQuery = true)
    int updateCategories();

    @Query(value = "show tables", nativeQuery = true)
    List<String> showTables();
}
