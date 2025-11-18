package com.main.estocafy.application.StorageLocation.controller.response;

import com.main.estocafy.application.User.controller.response.UserResponse;
import com.main.estocafy.application.Branch.controller.response.BranchResponse;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class StorageLocationResponse {
    private UUID id;
    private Instant createdAt;
    private String code;
    private String description;
    private Boolean isAvailable;
    private UserResponse user;
    private BranchResponse branch;
}

