package com.bjit.book_service.service;

import com.bjit.book_service.entity.UserEntity;
import com.bjit.book_service.model.AuthenticationRequest;
import com.bjit.book_service.model.AuthenticationResponse;
import com.bjit.book_service.model.UserRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<Object> register(UserRequestModel requestModel);
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);

    UserEntity findByEmail(String email);
}
