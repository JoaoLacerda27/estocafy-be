package com.main.estocafy.application.Supplier.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.main.estocafy.application.Supplier.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, UUID>, QuerydslPredicateExecutor<Supplier> {
}

