package com.ajouton.noname.domain.activity.dto;

import lombok.Builder;

import java.time.LocalDateTime;

//상세정보
@Builder
public record ActivityInfoResponse (
    String image,
    String content,
    String activityCategory,
    LocalDateTime createdAt,
    LocalDateTime updateAt
){
}
