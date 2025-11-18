package com.main.estocafy.application.ProductStock.dto;

import com.main.estocafy.shared.dtos.DtoBase;
import com.main.estocafy.application.Product.dto.ProductDTO;
import com.main.estocafy.application.User.dto.UserDTO;
import com.main.estocafy.application.StorageLocation.dto.StorageLocationDTO;
import com.main.estocafy.application.Branch.dto.BranchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ProductStockDTO extends DtoBase {
    private String batchNumber;
    private String shipmentCode;
    private LocalDate manufactureDate;
    private LocalDate expirationDate;
    private Long quantity;
    private Integer minQuantity;
    private Integer reservedQuantity;
    private ProductDTO product;
    private UserDTO userThatAdded;
    private StorageLocationDTO storageLocation;
    private BranchDTO branch;
}

