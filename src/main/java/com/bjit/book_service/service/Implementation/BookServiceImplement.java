package com.bjit.book_service.service.Implementation;

import com.bjit.book_service.entity.BookEntity;
import com.bjit.book_service.model.BookReqResModel;
import com.bjit.book_service.repository.BookRepository;
import com.bjit.book_service.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImplement implements BookService {

    private final BookRepository bookRepository;

    @Override
    public ResponseEntity<Object> insert(BookReqResModel bookRequestModel){
        System.out.println("enter");
        BookEntity bookEntity = BookEntity.builder()
                .bookName(bookRequestModel.getBookName())
                .author(bookRequestModel.getAuthor())
                .build();
        bookRepository.save(bookEntity);
        System.out.println("end");
        return new ResponseEntity<>("Book entry successful!", HttpStatus.CREATED);
    }

    @Override
    public List<BookEntity> findByAuthor(String authorName){
        return bookRepository.findAllByAuthor(authorName);
    }

    @Override
    public List<BookEntity> findById(Long id){
        return bookRepository.findAllById(id);
    }

    @Override
    public void delete(Long id){
        bookRepository.deleteById(id);
    }

    @Override
    public void update(BookReqResModel bookReqResModel, Long id) {

        //BookEntity bookEntity = bookRepository.findById(id).get();
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(id);

        if (bookEntityOptional.isPresent()) {
            BookEntity bookEntity = bookEntityOptional.get();

            bookEntity.setBookName(bookReqResModel.getBookName());
            bookEntity.setAuthor(bookReqResModel.getAuthor());
            bookRepository.save(bookEntity);
        } else {
            throw new RuntimeException();
        }
    }
}
