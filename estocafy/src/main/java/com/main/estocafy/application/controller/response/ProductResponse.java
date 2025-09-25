package com.main.estocafy.application.controller.response;

import lombok.Data;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Data
public class ProductResponse {
    private UUID id;
    private Instant createdAt;
    private String name;
    private String skuCode;
    private String barcode;
    private CategoryResponse category;
    private Set<SupplierResponse> suppliers;
    private Long minQuantity;
}
