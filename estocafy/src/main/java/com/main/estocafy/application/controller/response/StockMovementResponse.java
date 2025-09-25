package com.main.estocafy.application.controller.response;

import com.main.estocafy.application.domain.enums.MovementType;
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
    private ProductStockResponse productStock;
    private UserResponse user;
}
