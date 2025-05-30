package com.main.estocafy.application.repository;

import com.main.estocafy.application.domain.enums.RoleType;
import com.main.estocafy.application.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(RoleType name);
}
