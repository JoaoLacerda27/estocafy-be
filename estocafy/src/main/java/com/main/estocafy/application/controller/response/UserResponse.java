package com.main.estocafy.application.controller.response;

import com.main.estocafy.application.domain.model.Role;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserResponse {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Set<Role> roles;
    private PlanResponse plan;
}
