package com.ajouton.noname.domain.boss.notice.dto;

import lombok.Builder;

@Builder
public record CreateNoticeRequest(
        Long clubId,
        String noticeCategory,
        String title,
        String content,
        String image
) {
}
