package com.main.estocafy.application.Auth.controller.response;

import com.main.estocafy.application.Role.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class LoginResponse {
    private String token;
    private String tokenType;
    private String name;
    private String email;
    private Set<Role> roles;
}

