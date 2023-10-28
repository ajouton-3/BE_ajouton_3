package com.ajouton.noname.domain.activity.service;

import com.ajouton.noname.domain.activity.dto.ActivityInfoResponse;
import com.ajouton.noname.domain.activity.dto.ActivityListResponse;
import com.ajouton.noname.domain.activity.entity.Activity;
import com.ajouton.noname.domain.activity.repository.ActivityRepository;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class ActivityService {

    private final ActivityRepository activityRepository;

    public List<ActivityListResponse> showActivityList(Club club){
        List<ActivityListResponse> results = new ArrayList<>();

        List<Activity> allByClub = activityRepository.findAllByClub(club);
        for(Activity activity:allByClub){
            results.add(ActivityListResponse.builder()
                    .id(activity.getActivityId())
                    .image(activity.getImage())
                    .activityCategory(activity.getActivityCategory().getActivityCategory())
                    .build());
        }
        return results;

    }

    public ActivityInfoResponse showActivityInfo(int activityId){

        Activity activity = activityRepository.findById(activityId).orElseThrow(() -> new CustomException(ErrorCode.ERROR_1));

        ActivityInfoResponse result = ActivityInfoResponse.builder()
                .activityCategory(activity.getActivityCategory().getActivityCategory())
                .createdAt(activity.getCreatedAt())
                .content(activity.getContent())
                .updateAt(activity.getUpdatedAt())
                .build();

        return result;
    }
}
