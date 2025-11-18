package com.main.estocafy.application.StorageLocation.controller.request;

import com.main.estocafy.application.User.controller.request.UserRequest;
import lombok.Data;

@Data
public class StorageLocationRequest {
    private String code;
    private String description;
    private Boolean isAvailable;
    private UserRequest user;
}

