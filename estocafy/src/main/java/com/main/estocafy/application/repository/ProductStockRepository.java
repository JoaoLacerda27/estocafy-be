package com.main.estocafy.application.repository;

import com.main.estocafy.application.domain.model.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductStockRepository extends JpaRepository<ProductStock, UUID> {
}
