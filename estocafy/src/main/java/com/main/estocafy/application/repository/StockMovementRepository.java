package com.main.estocafy.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.main.estocafy.application.domain.model.StockMovement;

import java.util.UUID;

public interface StockMovementRepository extends JpaRepository<StockMovement, UUID>, QuerydslPredicateExecutor<StockMovement> {
    
}
