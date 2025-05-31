package com.main.estocafy.application.dto;

import com.main.estocafy.application.domain.model.Role;
import com.main.estocafy.shared.dtos.DtoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserDTO extends DtoBase {

    private String name;
    private String email;
    private String password;
    private String phone;
    private Set<Role> roles;
    private PlanDTO plan;
}
