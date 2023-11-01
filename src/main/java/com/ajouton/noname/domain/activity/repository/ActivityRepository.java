package com.ajouton.noname.domain.activity.repository;

import com.ajouton.noname.domain.activity.entity.Activity;
import com.ajouton.noname.domain.club.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Integer> {

    List<Activity> findAllByClub(Club club);
}

