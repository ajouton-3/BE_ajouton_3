package com.ajouton.noname.domain.test.repository;

import com.ajouton.noname.domain.test.entity.ImageTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageTestRepository extends JpaRepository<ImageTest,Long> {
}
