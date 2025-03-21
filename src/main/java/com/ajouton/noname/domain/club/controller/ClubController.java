package com.ajouton.noname.domain.club.controller;

import com.ajouton.noname.domain.club.dto.ClubInfoResponse;
import com.ajouton.noname.domain.club.dto.ClubListResponse;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.club.service.ClubMemberService;
import com.ajouton.noname.domain.club.service.ClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;
    private final ClubMemberService clubMemberService;

    //모든 카테고리 보기
    @GetMapping("/category")
    public ResponseEntity<List<String>> showAllClubCategory(){
        List<String> categories = clubService.showAllClubCategory();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //동아리 목록 가져오기, 검색어 있든 없든
    @GetMapping
    public ResponseEntity<List<ClubListResponse>> showAllClub(@RequestParam(required = false) String name) {
        List<ClubListResponse> clubListResponseList = clubService.showAllClub(name);

        return ResponseEntity.ok(clubListResponseList);
    }

    //동아리 상세정보 조회
    @GetMapping("/{clubId}")
    public ResponseEntity<ClubInfoResponse> showClubInfo(@PathVariable Long clubId){

        ClubInfoResponse clubInfoResponse = clubService.showClubInfo(clubId);

        return new ResponseEntity<>(clubInfoResponse, HttpStatus.OK);
    }

    //일정표시 설정하기
    @PostMapping("/{clubId}/users/{userId}/view")
    public ResponseEntity<String> viewOn(@PathVariable Long clubId,@PathVariable Long userId){

        clubMemberService.viewOn(clubId,userId);

        return new ResponseEntity<>("표시로 변경되었습니다", HttpStatus.OK);
    }
    @PostMapping("/{clubId}/users/{userId}/blind")
    public ResponseEntity<String> viewOff(@PathVariable Long clubId,@PathVariable Long userId){
        log.info("123");
        clubMemberService.viewOff(clubId,userId);

        return new ResponseEntity<>("숨김으로 변경되었습니다", HttpStatus.OK);
    }
}
