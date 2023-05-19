package com.bjit.book_service.config;

import com.bjit.book_service.exception.BookNotFoundException;
import com.bjit.book_service.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BookNotFoundException.class, UserNotFoundException.class})
    public ResponseEntity<Object> returnNotFoundException(Exception ex) {
        if(ex instanceof BookNotFoundException) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
       }
        else if(ex instanceof UserNotFoundException) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
