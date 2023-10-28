package com.ajouton.noname.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    ERROR_1(HttpStatus.BAD_REQUEST,1,"에러코드1"),
    ERROR_2(HttpStatus.BAD_REQUEST,2,"에러코드2"),
    ERROR_3(HttpStatus.BAD_REQUEST,3,"에러코드3"),
    USER_EXIST(HttpStatus.BAD_REQUEST, 4, "이미 가입된 회원입니다."),
    USER_NOT_EXIST(HttpStatus.NOT_FOUND, 5, "존재하지 않는 회원입니다."),
    SIGN_IN_FAILED(HttpStatus.BAD_REQUEST, 6, "로그인에 실패했습니다."),
    CLUB_NOT_EXIST(HttpStatus.NOT_FOUND, 7, "존재하지 않는 동아리입니다."),
    APPLY_EXIST(HttpStatus.BAD_REQUEST, 8, "이미 신청한 동아리입니다."),
    ALREADY_MEMBER(HttpStatus.BAD_REQUEST, 9, "이미 가입한 동아리입니다."),
    NOT_RECRUIT_SEASON(HttpStatus.BAD_REQUEST, 10, "동아리 신청기간이 아닙니다."),
    ALREADY_LIKE(HttpStatus.BAD_REQUEST, 11, "이미 찜한 동아리입니다."),
    LIKE_NOT_EXIST(HttpStatus.BAD_REQUEST, 12, "찜하지 않은 동아리입니다."),
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
