package com.ajouton.noname.domain.notice.controller;

import com.ajouton.noname.domain.activity.dto.ActivityInfoResponse;
import com.ajouton.noname.domain.activity.dto.ActivityListResponse;
import com.ajouton.noname.domain.activity.service.ActivityService;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.notice.dto.NoticeInfoResponse;
import com.ajouton.noname.domain.notice.dto.NoticeListResponse;
import com.ajouton.noname.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/notices")
public class NoticeController {

    private final NoticeService noticeService;

    //활동내역 리스트 보내주기
    @GetMapping("/{clubId}")
    public ResponseEntity<List<NoticeListResponse>> showActivityList(@PathVariable int clubId){
        //TODO: clubId로 club을 찾는다
        //Club club = clubService.find(clubId);
        Club club = Club.builder().build();
        List<NoticeListResponse> noticeListResponses = noticeService.showNoticeList(club);

        return new ResponseEntity<>(noticeListResponses, HttpStatus.OK);
    }

    //활동내역 상세 보여주기
    @GetMapping("/{noticeId}")
    public ResponseEntity<NoticeInfoResponse> showActivityInfo(@PathVariable int noticeId){

        NoticeInfoResponse noticeInfoResponse = noticeService.showNoticeInfo(noticeId);

        return new ResponseEntity<>(noticeInfoResponse, HttpStatus.OK);
    }

}
