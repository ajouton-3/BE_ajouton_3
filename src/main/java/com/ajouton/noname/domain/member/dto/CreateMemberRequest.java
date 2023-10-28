package com.ajouton.noname.domain.member.dto;

import lombok.Builder;

@Builder
public record CreateMemberRequest (
        String username,
        String password
){
}
