package com.ajouton.noname.domain.user.dto;

import lombok.Builder;

@Builder
public record CreateUserRequest(
        String name,
        String phoneNum,
        String studentId,
        String department
){
}
