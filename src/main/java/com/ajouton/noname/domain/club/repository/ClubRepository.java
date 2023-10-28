package com.ajouton.noname.domain.club.repository;

import com.ajouton.noname.domain.club.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club,Integer> {

    List<Club> findAllByClubName(String clubName);

}
