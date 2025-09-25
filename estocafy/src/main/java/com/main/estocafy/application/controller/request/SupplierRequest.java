package com.main.estocafy.application.controller.request;

import lombok.Data;

@Data
public class SupplierRequest {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String document;
}
