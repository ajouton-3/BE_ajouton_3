package com.ajouton.noname.domain.club.service;

import com.ajouton.noname.domain.club.dto.ClubInfoResponse;
import com.ajouton.noname.domain.club.dto.ClubListResponse;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.club.entity.ClubCategory;
import com.ajouton.noname.domain.club.repository.ClubCategoryRepository;
import com.ajouton.noname.domain.club.repository.ClubRepository;
import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
import com.ajouton.noname.domain.club.dto.ClubDto;
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
    private final ClubCategoryRepository clubCategoryRepository;

    public List<ClubListResponse> showAllClub(String searchedName) {

        List<Club> searchedClubs;
        List<ClubListResponse> clubListResponseList = new ArrayList<>();

        //전체 동아리목록 반환
        if(searchedName==null){
            searchedClubs = clubRepository.findAll();
        }else  //검색된 동아리목록 반환
        {
            searchedClubs = clubRepository.findAllByClubName(searchedName);
        }

        for(Club club:searchedClubs){
            clubListResponseList.add(ClubListResponse.builder()
                    .clubId(club.getClubId())
                    .clubName(club.getClubName())
                    .clubCategory(club.getClubCategory().getClubCategory())
                    .isRecruit(club.getIsRecruit())
                    .logo(club.getLogo())
                    .build());
        }
        //TODO: 만약 검색결과가 없다면 result가 뭐가 담기는지 예외처리추가하기
        return clubListResponseList;

    }

    public ClubInfoResponse showClubInfo(Long clubId){
        Club club = findById(clubId);
        ClubInfoResponse clubInfoResponse = ClubInfoResponse.builder()
                .clubId(club.getClubId())
                .clubName(club.getClubName())
                .clubCategory(club.getClubCategory().getClubCategory())
                .logo(club.getLogo())
                .description(club.getDescription())
                .target(club.getTarget())
                .fee(club.getFee())
                .contact(club.getContact())
                .isRecruit(club.getIsRecruit())
                .activityExpired(club.getActivityExpired())
                .build();
        return clubInfoResponse;

    }

    public List<String> showAllClubCategory(){
        List<String> categories = new ArrayList<>();
        List<ClubCategory> clubCategoryList = clubCategoryRepository.findAll();
        for(ClubCategory clubCategory:clubCategoryList){
            String categoryName = clubCategory.getClubCategory();
            categories.add(categoryName);
        }
        return categories;
    }



    public Club findById(Long clubId){
        log.info("serve");
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new CustomException(ErrorCode.ERROR_1));
        return club;
    }



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
