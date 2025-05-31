package com.main.estocafy.application.dto;

import com.main.estocafy.application.domain.enums.PlanType;
import com.main.estocafy.shared.dtos.DtoBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class PlanDTO extends DtoBase {
    private PlanType type;
    private boolean ativo;
}
