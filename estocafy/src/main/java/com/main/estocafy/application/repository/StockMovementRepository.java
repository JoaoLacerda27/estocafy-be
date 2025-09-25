package com.main.estocafy.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockMovementRepository extends JpaRepository<StockMovementRepository, UUID> {
    
}
