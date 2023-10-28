package com.ajouton.noname.domain.activity.dto;

import com.ajouton.noname.domain.activity.entity.ActivityCategory;
import lombok.Builder;

@Builder
public record ActivityListResponse (
        int id,
        String image,
        String activityCategory
){
}
