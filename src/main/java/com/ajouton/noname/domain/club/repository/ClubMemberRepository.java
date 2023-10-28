package com.ajouton.noname.domain.club.repository;

import com.ajouton.noname.domain.club.entity.ClubMember;
import com.ajouton.noname.domain.club.entity.ClubMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubMemberRepository extends JpaRepository<ClubMember, ClubMemberId> {
}
