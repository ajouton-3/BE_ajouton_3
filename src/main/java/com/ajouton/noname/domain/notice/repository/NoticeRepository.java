package com.ajouton.noname.domain.notice.repository;

import com.ajouton.noname.domain.activity.entity.Activity;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Integer> {

    List<Notice> findAllByClub(Club club);
}
