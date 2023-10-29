package com.ajouton.noname.domain.user.repository;

import com.ajouton.noname.domain.user.entity.LikeClubId;
import com.ajouton.noname.domain.user.entity.UserLikeClub;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLikeClubRepository extends JpaRepository<UserLikeClub, LikeClubId> {

  List<UserLikeClub> findByUserId(Long userId);

  boolean existsByUserIdAndClubId(Long userId, Long clubId);

  UserLikeClub findByUserIdAndClubId(Long userId, Long clubId);
}
