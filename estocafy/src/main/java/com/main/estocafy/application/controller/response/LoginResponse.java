package com.main.estocafy.application.controller.response;

import com.main.estocafy.application.domain.model.Role;
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
