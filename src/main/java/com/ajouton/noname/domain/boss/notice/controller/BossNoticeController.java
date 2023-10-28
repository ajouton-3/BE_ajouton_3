package com.ajouton.noname.domain.boss.notice.controller;

import com.ajouton.noname.domain.boss.notice.dto.CreateNoticeRequest;
import com.ajouton.noname.domain.notice.service.NoticeCategoryService;
import com.ajouton.noname.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/boss/notices")
public class BossNoticeController {

    private final NoticeService noticeService;
    private final NoticeCategoryService noticeCategoryService;

    @PostMapping("/category")
    public ResponseEntity createNoticeCategory(String noticeCategoryName){
        noticeCategoryService.createNoticeCategory(noticeCategoryName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/category")
    public ResponseEntity deleteNoticeCategory(String noticeCategoryName){
        noticeCategoryService.deleteNoticeCategory(noticeCategoryName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<String>> showAllNoticeCategory(){
        List<String> strings = noticeCategoryService.showAllNoticeCategory();
        return new ResponseEntity<>(strings, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createNotice(CreateNoticeRequest createNoticeRequest){
        noticeService.createNotice(createNoticeRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    //TODO:업데이트 해야됨.
    @PatchMapping("/{noticeID}")
    public ResponseEntity updateNotice(@PathVariable int noticeID, CreateNoticeRequest createNoticeRequest){
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{noticeID}")
    public ResponseEntity deleteNotice(@PathVariable int noticeID){
        noticeService.deleteNotice(noticeID);
        return new ResponseEntity(HttpStatus.OK);
    }
}
