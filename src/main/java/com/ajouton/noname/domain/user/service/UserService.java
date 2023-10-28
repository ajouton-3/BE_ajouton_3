package com.ajouton.noname.domain.user.service;

import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
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

    public void join(final CreateUserRequest createUserRequest){

        User createdUser = User.builder()
                .name(createUserRequest.name())
                .studentId(createUserRequest.studentId())
                .department(createUserRequest.department())
                .phoneNum(createUserRequest.phoneNum())
                .build();

        userRepository.save(createdUser);

    }

    public User showMemberById(final Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.ERROR_1));
        return user;
    }
}
