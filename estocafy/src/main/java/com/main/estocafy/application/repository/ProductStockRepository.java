package com.main.estocafy.application.repository;

import com.main.estocafy.application.domain.model.ProductStock;
import com.main.estocafy.application.repository.interfaces.ProductStockRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface ProductStockRepository extends JpaRepository<ProductStock, UUID>, QuerydslPredicateExecutor<ProductStock>, ProductStockRepositoryCustom {
}
