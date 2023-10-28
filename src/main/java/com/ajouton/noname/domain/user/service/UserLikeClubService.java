package com.ajouton.noname.domain.user.service;

import com.ajouton.noname.domain.user.entity.Member;
import com.ajouton.noname.domain.user.entity.UserLikeClub;
import com.ajouton.noname.domain.user.repository.UserLikeClubRepository;
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
public class UserLikeClubService {
  private final UserLikeClubRepository userLikeClubRepository;

  public List<Long> getUserLikeClubList(Long userId) {
    List<UserLikeClub> userLikeClubList = userLikeClubRepository
        .findByUserId(userId);
    List<Long> clubIdList = userLikeClubList.stream().map((club)-> club.getClubId()).collect(
        Collectors.toList());
    return clubIdList;
  }
}
