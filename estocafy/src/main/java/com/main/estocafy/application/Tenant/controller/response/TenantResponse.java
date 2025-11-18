package com.main.estocafy.application.Tenant.controller.response;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class TenantResponse {
    private UUID id;
    private Instant createdAt;
    private String name;
    private String code;
    private Boolean active;
}

