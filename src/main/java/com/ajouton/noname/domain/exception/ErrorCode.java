package com.ajouton.noname.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    ERROR_1(HttpStatus.BAD_REQUEST,1,"에러코드1"),
    ERROR_2(HttpStatus.BAD_REQUEST,2,"에러코드2"),
    ERROR_3(HttpStatus.BAD_REQUEST,3,"에러코드3"),
    USER_EXIST(HttpStatus.BAD_REQUEST, 4, "이미 가입된 회원입니다.")
    ;

    ErrorCode(HttpStatus statusCode,int customCode,String message){
        this.statusCode = statusCode;
        this.customCode = customCode;
        this.message = message;
    }

    private final HttpStatus statusCode;
    private final int customCode;
    private final String message;
}
