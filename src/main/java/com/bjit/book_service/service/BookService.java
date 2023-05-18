package com.bjit.book_service.service;

import com.bjit.book_service.entity.BookEntity;
import com.bjit.book_service.model.BookReqResModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    ResponseEntity<Object> insert(BookReqResModel bookRequestModel);
    List<BookEntity> findByAuthor(String authorName);

    List<BookEntity> findById(Long id);

    void delete(Long id);

    void update(BookReqResModel bookReqResModel, Long id);
}
