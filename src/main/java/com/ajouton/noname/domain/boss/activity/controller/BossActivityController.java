package com.ajouton.noname.domain.boss.activity.controller;

import com.ajouton.noname.domain.activity.service.ActivityService;
import com.ajouton.noname.domain.boss.activity.dto.PostActivityDto;
import com.ajouton.noname.domain.club.service.ClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/boss/activities")
@RestController
@Slf4j
public class BossActivityController {
  private final ActivityService activityService;
  private final ClubService clubService;

  @PostMapping("")
  public ResponseEntity postClubActivity(
      @RequestPart("image") MultipartFile image,
      @RequestParam("clubId") Long clubId,
      @RequestPart("postActivity") PostActivityDto postActivity) {
    clubService.isValidClub(clubId);
    activityService.postActivity(clubId, postActivity);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
