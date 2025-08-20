package com.main.estocafy.application.controller.request;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class ProductRequest {
    private String name;
    private String skuCode;
    private String barcode;
}
