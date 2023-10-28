package com.ajouton.noname.domain.user.repository;

import com.ajouton.noname.domain.user.entity.Member;
import com.ajouton.noname.domain.user.entity.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, MemberId> {
  boolean existsByUserIdAndClubIdAndRole(Long userId, Long clubId, String role);
}
