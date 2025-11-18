package com.main.estocafy.application.Branch.controller.response;

import com.main.estocafy.application.Tenant.controller.response.TenantResponse;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class BranchResponse {
    private UUID id;
    private Instant createdAt;
    private String name;
    private TenantResponse tenant;
    private Boolean active;
}

