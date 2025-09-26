package com.main.estocafy.application.controller.response;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ProductStockResponse {
    private UUID id;
    private Instant createdAt;
    private String batchNumber;
    private String shipmentCode;
    private LocalDate manufactureDate;
    private LocalDate expirationDate;
    private Long quantity;
    private Integer minQuantity;
    private Integer reservedQuantity;
    private ProductResponse product;
    private UserResponse userThatAdded;
    private StorageLocationResponse storageLocation;
    private BranchResponse branch;
}
