package com.ajouton.noname.domain.faq.repository;

import com.ajouton.noname.domain.activity.entity.Activity;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.faq.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaqRepository extends JpaRepository<Faq,Integer> {
    List<Faq> findAllByClub(Club club);
}
