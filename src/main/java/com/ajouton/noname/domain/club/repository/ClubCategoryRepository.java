package com.ajouton.noname.domain.club.repository;

import com.ajouton.noname.domain.club.entity.ClubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubCategoryRepository extends JpaRepository<ClubCategory,String> {
}
