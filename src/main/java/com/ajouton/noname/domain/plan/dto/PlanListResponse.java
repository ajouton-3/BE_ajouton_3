package com.ajouton.noname.domain.plan.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PlanListResponse(
    int planId,
    Long clubId,
    String content,
    LocalDateTime startDate,
    LocalDateTime endDate
) {
}
