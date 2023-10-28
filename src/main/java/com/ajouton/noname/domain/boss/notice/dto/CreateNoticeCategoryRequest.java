package com.ajouton.noname.domain.boss.notice.dto;

import lombok.Builder;

@Builder
public record CreateNoticeCategoryRequest(
        String noticeCategoryName
) {
}