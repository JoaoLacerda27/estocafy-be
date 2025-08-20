package com.main.estocafy.application.controller.request;

import com.main.estocafy.application.controller.response.UserResponse;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class StorageLocationRequest {
    private String code;
    private String description;
    private Boolean isAvailable;
    private UserRequest user;
}
