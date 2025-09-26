package com.main.estocafy.application.controller.response;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class BranchResponse {
    private UUID id;
    private Instant createdAt;
    private String name;
    private Boolean active;
    private TenantResponse tenant;
}
