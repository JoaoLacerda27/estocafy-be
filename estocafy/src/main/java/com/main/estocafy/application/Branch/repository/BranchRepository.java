package com.main.estocafy.application.Branch.repository;

import com.main.estocafy.application.Branch.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface BranchRepository extends JpaRepository<Branch, UUID>, QuerydslPredicateExecutor<Branch> {
}

