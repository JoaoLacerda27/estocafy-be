package com.main.estocafy.application.repository;

import com.main.estocafy.application.domain.enums.PlanType;
import com.main.estocafy.application.domain.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlanRepository extends JpaRepository<Plan, UUID> {
    Optional<Plan> findByType(PlanType type);
}
