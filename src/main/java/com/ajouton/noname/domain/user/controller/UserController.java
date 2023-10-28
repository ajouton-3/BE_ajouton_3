package com.ajouton.noname.domain.user.controller;


import com.ajouton.noname.domain.user.entity.User;
import com.ajouton.noname.domain.user.dto.CreateUserRequest;
import com.ajouton.noname.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<String> join(CreateUserRequest createUserRequest){
        userService.join(createUserRequest);
        return ResponseEntity.ok("회원가입 완료");
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<User> showMember(@PathVariable Long id){
        User user = userService.showMemberById(id);
        return ResponseEntity.ok(user);
    }
}
