package com.main.estocafy.application.Supplier.controller.response;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class SupplierResponse {
    private UUID id;
    private Instant createdAt;
    private Instant updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String document;
}

