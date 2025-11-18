package com.main.estocafy.application.User.repository;

import com.main.estocafy.application.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>, QuerydslPredicateExecutor<User> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}

