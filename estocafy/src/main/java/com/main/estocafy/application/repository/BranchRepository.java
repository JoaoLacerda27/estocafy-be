package com.main.estocafy.application.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.main.estocafy.application.domain.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, UUID>, QuerydslPredicateExecutor<Branch> {
    
}
