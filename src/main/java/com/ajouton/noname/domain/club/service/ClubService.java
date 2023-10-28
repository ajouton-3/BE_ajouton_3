package com.ajouton.noname.domain.club.service;

import com.ajouton.noname.domain.club.dto.ClubDto;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.club.repository.ClubRepository;
import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
import java.util.ArrayList;
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
public class ClubService {
  private final ClubRepository clubRepository;

  public void isValidClub(Long clubId) {
    if(!clubRepository.existsById(clubId)) {
      throw new CustomException(ErrorCode.CLUB_NOT_EXIST);
    }
  }

  public void isRecruitClub(Long clubId) {
    if(!clubRepository.existsByClubIdAndIsRecruit(clubId, 'Y')) {
      throw new CustomException(ErrorCode.NOT_RECRUIT_SEASON);
    }
  }

  public List<ClubDto> getClubList(List<Long> clubIdList) {
    List<Club> clubList = clubRepository.findAllById(clubIdList);
    List<ClubDto> result = clubList.stream()
        .map(club -> new ClubDto(club))
        .collect(Collectors.toList());
    return result;
  }
}
