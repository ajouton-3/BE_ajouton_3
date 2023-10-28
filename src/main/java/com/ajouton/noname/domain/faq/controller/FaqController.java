package com.ajouton.noname.domain.faq.controller;

import com.ajouton.noname.domain.activity.dto.ActivityListResponse;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.club.service.ClubService;
import com.ajouton.noname.domain.faq.dto.FaqListResponse;
import com.ajouton.noname.domain.faq.service.FaqService;
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
@RequestMapping("/faqs")
public class FaqController {

    private final FaqService faqService;
    private final ClubService clubService;

    //FAQ 리스트 보내주기
    @GetMapping("/{clubId}")
    public ResponseEntity<List<FaqListResponse>> showFaqList(@PathVariable Long clubId){

        Club club = clubService.findById(clubId);

        List<FaqListResponse> faqListResponses = faqService.showFaqList(club);

        return new ResponseEntity<>(faqListResponses, HttpStatus.OK);
    }
}
