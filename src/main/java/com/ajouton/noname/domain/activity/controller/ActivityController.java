package com.ajouton.noname.domain.activity.controller;

import com.ajouton.noname.domain.activity.dto.ActivityInfoResponse;
import com.ajouton.noname.domain.activity.dto.ActivityListResponse;
import com.ajouton.noname.domain.activity.service.ActivityService;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.club.service.ClubService;
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
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService activityService;
    private final ClubService clubService;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
    //활동내역 리스트 보내주기
    @GetMapping("/all/{clubId}")
    public ResponseEntity<List<ActivityListResponse>> showActivityList(@PathVariable Long clubId){

        Club club = clubService.findById(clubId);

        List<ActivityListResponse> activityListResponses = activityService.showActivityList(club);

        return new ResponseEntity<>(activityListResponses, HttpStatus.OK);
    }

    //활동내역 상세 보여주기
    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityInfoResponse> showActivityInfo(@PathVariable int activityId){
        ActivityInfoResponse activityInfoResponse = activityService.showActivityInfo(activityId);

        return new ResponseEntity<>(activityInfoResponse, HttpStatus.OK);
    }

}
