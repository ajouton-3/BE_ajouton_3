package com.ajouton.noname.domain.faq.dto;

import lombok.Builder;

@Builder
public record FaqListResponse(
        String question,
        String answer
) {
}
