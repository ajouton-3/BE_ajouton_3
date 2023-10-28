package com.ajouton.noname.domain.boss.activity.controller;

import com.ajouton.noname.domain.activity.service.ActivityService;
import com.ajouton.noname.domain.boss.activity.dto.ActivityDto;
import com.ajouton.noname.domain.boss.activity.dto.PatchActivityDto;
import com.ajouton.noname.domain.boss.activity.dto.PostActivityDto;
import com.ajouton.noname.domain.club.service.ClubService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("")
  public ResponseEntity<List<ActivityDto>> getClubActivityList(@RequestParam("clubId") Long clubId) {
    clubService.isValidClub(clubId);
    List<ActivityDto> clubActivityResult = activityService.getClubActivityList(clubId);
    return ResponseEntity.status(HttpStatus.OK).body(clubActivityResult);
  }

  @PatchMapping("/{activityId}")
  public ResponseEntity patchClubActivity(
      @RequestPart("image") MultipartFile image,
      @PathVariable("activityId") int activityId,
      @RequestPart("patchActivity") PatchActivityDto patchActivityDto) {

    activityService.patchActivity(activityId, patchActivityDto);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
