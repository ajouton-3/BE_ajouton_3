package com.ajouton.noname.domain.boss.faq.controller;

import com.ajouton.noname.domain.boss.faq.dto.FaqDto;
import com.ajouton.noname.domain.boss.faq.dto.PatchFaqDto;
import com.ajouton.noname.domain.boss.faq.dto.PostFaqDto;
import com.ajouton.noname.domain.club.service.ClubService;
import com.ajouton.noname.domain.faq.service.FaqService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/boss/faq")
@RestController
@Slf4j
public class BossFaqController {

  private final FaqService faqService;
  private final ClubService clubService;

  @PostMapping("")
  public ResponseEntity postFaq(
      @RequestParam("clubId") Long clubId,
      @RequestBody PostFaqDto postFaqDto) {
    clubService.isValidClub(clubId);
    faqService.postFaq(clubId, postFaqDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("")
  public ResponseEntity<List<FaqDto>> getClubFaqList(@RequestParam("clubId") Long clubId) {
    clubService.isValidClub(clubId);
    List<FaqDto> faqList = faqService.getClubFaqList(clubId);
    return ResponseEntity.status(HttpStatus.OK).body(faqList);
  }

  @PatchMapping("/{faqId}")
  public ResponseEntity patchFaq(
      @PathVariable("faqId") int faqId,
      @RequestBody PatchFaqDto patchFaqDto) {
    faqService.isValidFaq(faqId);
    faqService.patchFaq(faqId, patchFaqDto);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{faqId}")
  public ResponseEntity deleteFaq(@PathVariable("faqId") int faqId) {
    faqService.isValidFaq(faqId);
    faqService.deleteFaq(faqId);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
