package com.main.estocafy.application.Product.controller.request;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class ProductRequest {
    private String name;
    private String skuCode;
    private String barcode;
    private UUID categoryId;
    private Set<UUID> supplierIds;
    private Long minQuantity;
}

