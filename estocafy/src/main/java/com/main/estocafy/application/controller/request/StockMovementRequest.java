package com.main.estocafy.application.controller.request;

import com.main.estocafy.application.domain.enums.MovementType;
import lombok.Data;

import java.util.UUID;

@Data
public class StockMovementRequest {
    private MovementType type;
    private Long quantity;
    private UUID productStockId;
    private UUID userId;
}
