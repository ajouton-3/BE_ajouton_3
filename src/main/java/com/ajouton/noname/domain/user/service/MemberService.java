package com.ajouton.noname.domain.user.service;

import com.ajouton.noname.domain.club.dto.ClubDto;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
import com.ajouton.noname.domain.user.entity.Member;
import com.ajouton.noname.domain.user.entity.MemberId;
import com.ajouton.noname.domain.user.repository.MemberRepository;
import java.util.List;
import java.util.stream.Collectors;
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

  public boolean isExistApply(Long userId, Long clubId) {
    if (memberRepository.existsByUserIdAndClubIdAndRole(userId, clubId, "임시회원")) return true;
    return false;
  }

  public boolean isExistMember(Long userId, Long clubId) {
    if (memberRepository.existsByUserIdAndClubIdAndRole(userId, clubId, "회원")) return true;
    return false;
  }



  public void postMemberApply(Long userId, Long clubId) {
    if(this.isExistApply(userId, clubId)) {
      throw new CustomException(ErrorCode.APPLY_EXIST);
    }
    if(this.isExistMember(userId, clubId)) {
      throw new CustomException(ErrorCode.ALREADY_MEMBER);
    }

    Member member = new Member();
    member.setUserId(userId);
    member.setClubId(clubId);
    member.setRole("임시회원");

    memberRepository.save(member);
  }

  public List<Long> getUserClubMemberList(Long userId) {
    List<Member> userMemberList = memberRepository
        .findByUserIdAndRoleOrderByCreatedAtDesc(userId, "회원");
    List<Long> clubIdList = userMemberList.stream().map((club)-> club.getClubId()).collect(
        Collectors.toList());
    return clubIdList;
  }

}
