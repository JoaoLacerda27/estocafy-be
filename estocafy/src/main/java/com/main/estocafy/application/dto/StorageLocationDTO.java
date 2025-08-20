package com.main.estocafy.application.dto;

import com.main.estocafy.shared.dtos.DtoBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class StorageLocationDTO extends DtoBase {
    private String code;
    private String description;
    private Boolean isAvailable;
    private UserDTO user;
}
