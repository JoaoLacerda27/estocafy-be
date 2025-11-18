package com.main.estocafy.application.User.controller.request;

import com.main.estocafy.application.Role.model.Role;
import com.main.estocafy.application.Plan.controller.request.PlanRequest;
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

