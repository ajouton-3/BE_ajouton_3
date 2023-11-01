package com.ajouton.noname.domain.user.service;

import com.ajouton.noname.domain.club.repository.ClubRepository;
import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
import com.ajouton.noname.domain.user.dto.*;
import com.ajouton.noname.domain.user.entity.User;
import com.ajouton.noname.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    // 존재하는 사용자인지 확인
    public void isValidUser(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new CustomException(ErrorCode.USER_NOT_EXIST);
        }
    }

    public void signUp(SignUpDto signUpDto) {
        if(userRepository.existsByStudentId(signUpDto.getStudentId())) {
            throw new CustomException(ErrorCode.USER_EXIST);
        }

        User user = new User();
        user.setName(signUpDto.getUsername());
        user.setStudentId(signUpDto.getStudentId());
        user.setDepartment(signUpDto.getDepartment());
        user.setPhoneNum(signUpDto.getPhoneNum());
        user.setPassword(signUpDto.getPassword());

        userRepository.save(user);
    }

    public SignInResponse signIn(SignInDto signInDto) {
        User user = userRepository.findByStudentId(signInDto.getStudentId())
            .orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_EXIST));
        if(!user.getPassword().equals(signInDto.getPassword())) {
            throw new CustomException(ErrorCode.SIGN_IN_FAILED);
        }
        SignInResponse result = SignInResponse.builder()
                .department(user.getDepartment())
                .phoneNum(user.getPhoneNum())
                .studentId(user.getStudentId())
                .userId(user.getUserId())
                .name(user.getName())
                .build();
        return result;

    }

    public UserInfoResponseDto getUserInfo(Long userId) {
        User user = userRepository.findById(userId).get();
        return new UserInfoResponseDto(user);
    }
}
