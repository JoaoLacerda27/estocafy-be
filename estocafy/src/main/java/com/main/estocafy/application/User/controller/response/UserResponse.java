package com.main.estocafy.application.User.controller.response;

import com.main.estocafy.application.Role.model.Role;
import com.main.estocafy.application.Plan.controller.response.PlanResponse;
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

