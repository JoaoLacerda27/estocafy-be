package com.main.estocafy.application.StorageLocation.dto;

import com.main.estocafy.shared.dtos.DtoBase;
import com.main.estocafy.application.User.dto.UserDTO;
import com.main.estocafy.application.Branch.dto.BranchDTO;
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
    private BranchDTO branch;
}

