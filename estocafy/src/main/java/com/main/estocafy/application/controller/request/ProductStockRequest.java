package com.main.estocafy.application.controller.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductStockRequest {
    private String batchNumber;
    private String shipmentCode;
    private LocalDate manufactureDate;
    private LocalDate expirationDate;
    private Long quantity;
    private Integer minQuantity;
    private Integer reservedQuantity;
    private ProductRequest product;
    private UserRequest userThatAdded;
    private StorageLocationRequest storageLocation;
}
