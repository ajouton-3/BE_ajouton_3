package com.ajouton.noname.domain.user.dto;

import lombok.Builder;

@Builder
public record SignInResponse(
        Long userId,
        String name,
        String phoneNum,
        String studentId,
        String department
) {
}
