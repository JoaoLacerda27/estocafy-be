package com.main.estocafy.application.controller.request;

import com.main.estocafy.application.domain.model.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private String phone;
    private Set<Role> roles;
    private PlanRequest plan;
}
