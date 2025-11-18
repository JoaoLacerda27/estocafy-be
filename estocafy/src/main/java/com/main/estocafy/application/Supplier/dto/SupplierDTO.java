package com.main.estocafy.application.Supplier.dto;

import com.main.estocafy.shared.dtos.DtoBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO extends DtoBase {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String document;
}

