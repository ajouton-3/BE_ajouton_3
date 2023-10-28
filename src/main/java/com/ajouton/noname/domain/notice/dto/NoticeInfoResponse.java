package com.ajouton.noname.domain.notice.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record NoticeInfoResponse(
        String title,
        String content,
        String image,
        LocalDateTime createdAt,
        LocalDateTime updateAt
) {
}
