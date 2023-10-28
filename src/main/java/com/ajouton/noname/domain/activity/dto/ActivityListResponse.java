package com.ajouton.noname.domain.activity.dto;

import lombok.Builder;

@Builder
public record ActivityListResponse (
        int id,
        String image,
        String activityCategory
){
}
