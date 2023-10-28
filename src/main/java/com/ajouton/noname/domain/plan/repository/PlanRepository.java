package com.ajouton.noname.domain.plan.repository;

import com.ajouton.noname.domain.plan.entity.Plan;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan,Integer> {
}
