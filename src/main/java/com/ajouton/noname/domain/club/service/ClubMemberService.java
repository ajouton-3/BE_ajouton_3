package com.ajouton.noname.domain.club.service;

import com.ajouton.noname.domain.club.entity.ClubMember;
import com.ajouton.noname.domain.club.entity.ClubMemberId;
import com.ajouton.noname.domain.club.repository.ClubMemberRepository;
import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class ClubMemberService {

    private final ClubMemberRepository clubMemberRepository;

    public void viewOn(Long clubId,Long userId){
        ClubMemberId clubMemberID = createClubMemberID(clubId, userId);
        ClubMember clubMember = clubMemberRepository.findById(clubMemberID).orElseThrow(() -> new CustomException(ErrorCode.ERROR_1));

        if(clubMember.getIsView()=='Y'){
            throw new CustomException(ErrorCode.ERROR_1);
        }

        clubMember.setViewON();
        clubMemberRepository.save(clubMember);
    }

    public void viewOff(Long clubId,Long userId){
        ClubMemberId clubMemberID = createClubMemberID(clubId, userId);
        ClubMember clubMember = clubMemberRepository.findById(clubMemberID).orElseThrow(() -> new CustomException(ErrorCode.ERROR_1));

        if(clubMember.getIsView()=='N'){
            throw new CustomException(ErrorCode.ERROR_1);
        }

        clubMember.setViewOff();
        clubMemberRepository.save(clubMember);
    }

    private ClubMemberId createClubMemberID(Long clubId,Long userId){
        ClubMemberId clubMemberId = new ClubMemberId();
        clubMemberId.setClubId(clubId);
        clubMemberId.setUserId(userId);
        return clubMemberId;
    }

    public List<Long> findAllClubIdsByUserId(Long userId){
        log.info("11234");
        List<ClubMember> clubMembers = clubMemberRepository.findAllByUserId(userId);
        log.info("2222234");
        List<Long> clubIds = new ArrayList<>();

        for(ClubMember clubMember:clubMembers){
            if(clubMember.getIsView()=='Y'){
                clubIds.add(clubMember.getClubId());
            }
        }
        return clubIds;
    }

}
