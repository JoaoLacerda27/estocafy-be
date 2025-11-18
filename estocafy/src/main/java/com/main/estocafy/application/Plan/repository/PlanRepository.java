package com.main.estocafy.application.Plan.repository;

import com.main.estocafy.application.Plan.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface PlanRepository extends JpaRepository<Plan, UUID>, QuerydslPredicateExecutor<Plan> {
}

