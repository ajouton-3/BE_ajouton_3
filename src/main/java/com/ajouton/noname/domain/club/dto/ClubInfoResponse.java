package com.ajouton.noname.domain.club.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ClubInfoResponse(
        Long clubId,
        String clubCategory,
        String clubName,
        String logo,
        String description,
        String target,
        int fee,
        String contact,
        char isRecruit,
        LocalDateTime activityExpired
) {
}
