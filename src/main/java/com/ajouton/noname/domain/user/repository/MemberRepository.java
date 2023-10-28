package com.ajouton.noname.domain.user.repository;

import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.user.entity.Member;
import com.ajouton.noname.domain.user.entity.MemberId;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, MemberId> {
  boolean existsByUserIdAndClubIdAndRole(Long userId, Long clubId, String role);

  List<Member> findByUserIdAndRoleOrderByCreatedAtDesc(Long userId, String role);

  Optional<Member> findByUserIdAndClubId(Long userId, Long clubId);
}
