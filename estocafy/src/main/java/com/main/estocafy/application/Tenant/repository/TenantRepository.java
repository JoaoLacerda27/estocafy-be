package com.main.estocafy.application.Tenant.repository;

import com.main.estocafy.application.Tenant.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface TenantRepository extends JpaRepository<Tenant, UUID>, QuerydslPredicateExecutor<Tenant> {
}

