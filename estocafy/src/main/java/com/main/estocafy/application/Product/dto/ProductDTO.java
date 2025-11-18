package com.main.estocafy.application.Product.dto;

import com.main.estocafy.application.Category.dto.CategoryDTO;
import com.main.estocafy.application.Supplier.dto.SupplierDTO;
import com.main.estocafy.shared.dtos.DtoBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ProductDTO extends DtoBase {
    private String name;
    private String skuCode;
    private String barcode;
    private CategoryDTO category;
    private Set<SupplierDTO> suppliers;
    private Long minQuantity;
}

