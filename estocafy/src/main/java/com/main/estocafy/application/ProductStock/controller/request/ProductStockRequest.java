package com.main.estocafy.application.ProductStock.controller.request;

import com.main.estocafy.application.Product.controller.request.ProductRequest;
import com.main.estocafy.application.User.controller.request.UserRequest;
import com.main.estocafy.application.StorageLocation.controller.request.StorageLocationRequest;
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

