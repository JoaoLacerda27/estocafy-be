package com.main.estocafy.application.Category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.main.estocafy.application.Category.model.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID>, QuerydslPredicateExecutor<Category> {
    
}

