package com.bjit.book_service.controller;

import com.bjit.book_service.entity.UserEntity;
import com.bjit.book_service.exception.UserNotFoundException;
import com.bjit.book_service.model.AuthenticationRequest;
import com.bjit.book_service.model.AuthenticationResponse;
import com.bjit.book_service.model.UserRequestModel;
import com.bjit.book_service.repository.UserRepository;
import com.bjit.book_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserRequestModel requestModel){
        return userService.register(requestModel);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        UserEntity u = userRepository.findByEmail(authenticationRequest.getEmail());
        if(u == null){
            throw new UserNotFoundException("User not found!!");
        }
        else {
            return new ResponseEntity<>(userService.login(authenticationRequest), HttpStatus.OK);
        }
    }
}