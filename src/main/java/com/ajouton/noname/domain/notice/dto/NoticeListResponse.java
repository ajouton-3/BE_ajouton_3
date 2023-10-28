package com.ajouton.noname.domain.notice.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record NoticeListResponse(
        int noticeId,
        String title,
        String noticeCategory,
        LocalDateTime createdAt
) {
}
