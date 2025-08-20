package com.main.estocafy.application.dto;

import com.main.estocafy.shared.dtos.DtoBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ProductDTO extends DtoBase {
    private String name;
    private String skuCode;
    private String barcode;
}
