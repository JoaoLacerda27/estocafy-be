package com.main.estocafy.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.estocafy.application.domain.model.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    
}
