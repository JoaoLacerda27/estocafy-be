package com.main.estocafy.application.Role.repository;

import com.main.estocafy.application.Role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID>, QuerydslPredicateExecutor<Role> {
}

