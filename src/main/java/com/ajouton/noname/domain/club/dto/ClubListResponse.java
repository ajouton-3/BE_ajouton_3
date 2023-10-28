package com.ajouton.noname.domain.club.dto;

import lombok.Builder;

@Builder
public record ClubListResponse(
        //TODO:동아리찜유무 추가하기
        int clubId,
        String clubName,
        String clubCategory,
        String isRecruit,
        String logo
) {
}
