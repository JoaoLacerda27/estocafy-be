package com.main.estocafy.application.Branch.dto;

import com.main.estocafy.shared.dtos.DtoBase;
import com.main.estocafy.application.Tenant.dto.TenantDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BranchDTO extends DtoBase {
    private String name;
    private TenantDTO tenant;
    private Boolean active;
}

