package com.main.estocafy.application.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierRepository, UUID> {
}
