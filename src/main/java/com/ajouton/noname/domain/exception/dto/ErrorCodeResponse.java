package com.ajouton.noname.domain.exception.dto;

import lombok.Builder;

@Builder
public record ErrorCodeResponse (
        int customCode,
        String message
){
}
