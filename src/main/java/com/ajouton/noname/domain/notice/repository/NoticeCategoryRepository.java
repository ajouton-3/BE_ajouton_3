package com.ajouton.noname.domain.notice.repository;

import com.ajouton.noname.domain.notice.entity.NoticeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeCategoryRepository extends JpaRepository<NoticeCategory,String> {
}
