package com.ajouton.noname.domain.member.service;

import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
import com.ajouton.noname.domain.member.entity.Member;
import com.ajouton.noname.domain.member.dto.CreateMemberRequest;
import com.ajouton.noname.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public void join(final CreateMemberRequest createMemberRequest){

        Member createdMember = Member.builder()
                .name(createMemberRequest.name())
                .studentId(createMemberRequest.studentId())
                .department(createMemberRequest.department())
                .phoneNum(createMemberRequest.phoneNum())
                .build();

        memberRepository.save(createdMember);

    }

    public Member showMemberById(final Long id){
        Member member = memberRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.ERROR_1));
        return member;
    }
}
