package com.ajouton.noname.domain.user.controller;


import com.ajouton.noname.domain.user.dto.SignUpDto;
import com.ajouton.noname.domain.user.entity.User;
import com.ajouton.noname.domain.user.dto.CreateUserRequest;
import com.ajouton.noname.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody SignUpDto signUpDto) {
        userService.signUp(signUpDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
