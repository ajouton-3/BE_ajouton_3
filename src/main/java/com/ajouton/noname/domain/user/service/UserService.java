package com.ajouton.noname.domain.user.service;

import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
import com.ajouton.noname.domain.user.dto.SignUpDto;
import com.ajouton.noname.domain.user.entity.User;
import com.ajouton.noname.domain.user.dto.CreateUserRequest;
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
}
