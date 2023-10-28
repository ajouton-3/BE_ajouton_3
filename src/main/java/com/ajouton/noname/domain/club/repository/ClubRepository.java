package com.ajouton.noname.domain.club.repository;

import com.ajouton.noname.domain.club.entity.Club;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club,Long> {
  boolean existsByClubIdAndIsRecruit(Long clubId, char isRecruit);
}
