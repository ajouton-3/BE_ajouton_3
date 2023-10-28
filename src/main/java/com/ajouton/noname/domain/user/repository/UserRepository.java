package com.ajouton.noname.domain.user.repository;

import com.ajouton.noname.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

  boolean existsByStudentId(String studentId);

  Optional<User> findByStudentId(String studentId);
}
