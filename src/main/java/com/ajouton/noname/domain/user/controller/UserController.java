package com.ajouton.noname.domain.user.controller;


import com.ajouton.noname.domain.club.service.ClubService;
import com.ajouton.noname.domain.user.dto.SignInDto;
import com.ajouton.noname.domain.user.dto.SignUpDto;
import com.ajouton.noname.domain.user.dto.UserInfoResponseDto;
import com.ajouton.noname.domain.user.entity.User;
import com.ajouton.noname.domain.user.dto.CreateUserRequest;
import com.ajouton.noname.domain.user.service.MemberService;
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
    private final ClubService clubService;

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody SignUpDto signUpDto) {
        userService.signUp(signUpDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity signIn(@RequestBody SignInDto signInDto) {
        userService.signIn(signInDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{userId}/info")
    public ResponseEntity<UserInfoResponseDto> getUserInfo(@PathVariable("userId") Long userId) {
        userService.isValidUser(userId);
        UserInfoResponseDto userInfoResult = userService.getUserInfo(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userInfoResult);
    }

    @PostMapping("/{userId}/clubs/{clubId}/apply")
    public ResponseEntity postUserClubApply(
        @PathVariable("userId") Long userId,
        @PathVariable("clubId") Long clubId) {
        userService.isValidUser(userId);
        clubService.isRecruitClub(clubId);
        memberService.postMemberApply(userId, clubId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
