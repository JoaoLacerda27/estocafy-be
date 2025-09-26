package com.main.estocafy.application.dto;

import com.main.estocafy.application.domain.enums.MovementType;
import com.main.estocafy.shared.dtos.DtoBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StockMovementDTO extends DtoBase {
    private Instant movementDate;
    private MovementType type;
    private Long quantity;
    private Long previousQuantity;
    private Long resultingQuantity;
    private String reason;
    private ProductStockDTO productStock;
    private UserDTO user;
    private BranchDTO sourceBranch;
    private BranchDTO targetBranch;
    private StorageLocationDTO sourceStorage;
    private StorageLocationDTO targetStorage;
}

