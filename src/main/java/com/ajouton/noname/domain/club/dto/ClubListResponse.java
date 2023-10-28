package com.ajouton.noname.domain.club.dto;

import lombok.Builder;

@Builder
public record ClubListResponse(
        //TODO:동아리찜유무 추가하기
        Long clubId,
        String clubName,
        String clubCategory,
        char isRecruit,
        String logo
) {
}
