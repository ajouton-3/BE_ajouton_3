package com.ajouton.noname.domain.user.controller;


import com.ajouton.noname.domain.club.dto.ClubDto;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.club.service.ClubService;
import com.ajouton.noname.domain.user.dto.*;
import com.ajouton.noname.domain.user.entity.User;
import com.ajouton.noname.domain.user.service.MemberService;
import com.ajouton.noname.domain.user.service.UserLikeClubService;
import com.ajouton.noname.domain.user.service.UserService;
import java.util.List;
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
    private final UserLikeClubService userLikeClubService;

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody SignUpDto signUpDto) {
        userService.signUp(signUpDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInDto signInDto) {
        SignInResponse signInResponse = userService.signIn(signInDto);
        return new ResponseEntity<>(signInResponse, HttpStatus.OK);

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
        clubService.isValidClub(clubId);
        clubService.isRecruitClub(clubId);
        memberService.postMemberApply(userId, clubId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{userId}/clubs")
    public ResponseEntity<List<ClubDto>> getUserClubList(@PathVariable("userId") Long userId) {
        userService.isValidUser(userId);
        List<Long> memberClubList = memberService.getUserClubList(userId, "회원");

        List<ClubDto> clubList = clubService.getClubList(memberClubList);
        return ResponseEntity.status(HttpStatus.OK)
            .body(clubList);
    }

    @GetMapping("/{userId}/clubs/apply")
    public ResponseEntity<List<ClubDto>> getUserClubApplyList(@PathVariable("userId") Long userId) {
        userService.isValidUser(userId);
        List<Long> clubApplyList = memberService.getUserClubList(userId, "임시회원");

        List<ClubDto> clubList = clubService.getClubList(clubApplyList);
        return ResponseEntity.status(HttpStatus.OK)
            .body(clubList);
    }
    @GetMapping("/{userId}/clubs/like")
    public ResponseEntity<List<ClubDto>> getUserLikeClubList(@PathVariable("userId") Long userId) {
        userService.isValidUser(userId);
        List<Long> clubApplyList = userLikeClubService.getUserLikeClubList(userId);

        List<ClubDto> clubList = clubService.getClubList(clubApplyList);
        return ResponseEntity.status(HttpStatus.OK)
            .body(clubList);
    }

    @PostMapping("/{userId}/clubs/{clubId}/like")
    public ResponseEntity postUserLikeClub(
        @PathVariable("userId") Long userId,
        @PathVariable("clubId") Long clubId) {
        userService.isValidUser(userId);
        clubService.isValidClub(clubId);

        userLikeClubService.postUserLikeClub(userId, clubId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{userId}/clubs/{clubId}/dislike")
    public ResponseEntity deleteUserLikeClub(
        @PathVariable("userId") Long userId,
        @PathVariable("clubId") Long clubId) {
        userService.isValidUser(userId);
        clubService.isValidClub(clubId);

        userLikeClubService.deleteUserLikeClub(userId, clubId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
