package com.ajouton.noname.domain.member.dto;

import lombok.Builder;

@Builder
public record CreateMemberRequest (
        String name,
        String phoneNum,
        String studentId,
        String department
){
}
