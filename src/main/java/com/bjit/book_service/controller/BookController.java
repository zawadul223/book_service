package com.bjit.book_service.controller;

import com.bjit.book_service.entity.BookEntity;
import com.bjit.book_service.model.BookReqResModel;
import com.bjit.book_service.repository.BookRepository;
import com.bjit.book_service.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody BookReqResModel bookReqResModel){
        return bookService.insert(bookReqResModel);
    }

    @GetMapping("/all")
    public List<BookEntity> all(){
        return bookRepository.findAll();
    }

    @GetMapping("/author/{authorName}")
    public List<BookEntity> authorSpecific(@PathVariable String authorName){
        return bookService.findByAuthor(authorName);
    }

    @GetMapping("/id/{id}")
    public List<BookEntity> idSpecific(@PathVariable Long id){
        return bookService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        bookService.delete(id);
        return "Book has been deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody BookReqResModel bookReqResModel){

        Long id = bookReqResModel.getId();
        bookService.update(bookReqResModel,id);

        return "Updated successfully";
    }
}
