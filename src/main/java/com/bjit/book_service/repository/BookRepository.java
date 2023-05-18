package com.bjit.book_service.repository;

import com.bjit.book_service.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findAllById(Long Id);
    //List<BookEntity> findById(Long id);
    List<BookEntity> findAllByAuthor(String authorName);

    void deleteById(Long id);
}
