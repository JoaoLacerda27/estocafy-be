package com.main.estocafy.application.StockMovement.controller.request;

import com.main.estocafy.application.StockMovement.enums.MovementType;
import lombok.Data;

import java.util.UUID;

@Data
public class StockMovementRequest {
    private MovementType type;
    private Long quantity;
    private Long previousQuantity;
    private Long resultingQuantity;
    private String reason;
    private UUID productStockId;
    private UUID userId;
    private UUID sourceBranchId;
    private UUID targetBranchId;
    private UUID sourceStorageId;
    private UUID targetStorageId;
}

