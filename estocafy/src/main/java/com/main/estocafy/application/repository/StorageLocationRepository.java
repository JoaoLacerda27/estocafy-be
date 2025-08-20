package com.main.estocafy.application.repository;

import com.main.estocafy.application.domain.model.StorageLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StorageLocationRepository extends JpaRepository<StorageLocation, UUID> {
}
