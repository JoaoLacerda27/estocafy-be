package com.main.estocafy.application.repository;

import com.main.estocafy.application.domain.enums.PlanType;
import com.main.estocafy.application.domain.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;
import java.util.UUID;

public interface PlanRepository extends JpaRepository<Plan, UUID>, QuerydslPredicateExecutor<Plan> {
    Optional<Plan> findByType(PlanType type);
}
