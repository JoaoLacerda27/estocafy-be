package com.main.estocafy.application.StockMovement.controller.response;

import com.main.estocafy.application.StockMovement.enums.MovementType;
import com.main.estocafy.application.ProductStock.controller.response.ProductStockResponse;
import com.main.estocafy.application.User.controller.response.UserResponse;
import com.main.estocafy.application.Branch.controller.response.BranchResponse;
import com.main.estocafy.application.StorageLocation.controller.response.StorageLocationResponse;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class StockMovementResponse {
    private UUID id;
    private Instant createdAt;
    private Instant updatedAt;
    private UUID createdBy;
    private UUID updatedBy;
    private Instant movementDate;
    private MovementType type;
    private Long quantity;
    private Long previousQuantity;
    private Long resultingQuantity;
    private String reason;
    private ProductStockResponse productStock;
    private UserResponse user;
    private BranchResponse sourceBranch;
    private BranchResponse targetBranch;
    private StorageLocationResponse sourceStorage;
    private StorageLocationResponse targetStorage;
}

