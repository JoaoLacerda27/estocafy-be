package com.main.estocafy.application.StorageLocation.repository;

import com.main.estocafy.application.StorageLocation.model.StorageLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface StorageLocationRepository extends JpaRepository<StorageLocation, UUID>, QuerydslPredicateExecutor<StorageLocation> {
}

