package com.main.estocafy.application.controller.request;

import lombok.Data;
@Data
public class StorageLocationRequest {
    private String code;
    private String description;
    private Boolean isAvailable;
    private UserRequest user;
}
