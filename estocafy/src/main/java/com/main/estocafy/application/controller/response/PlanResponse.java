package com.main.estocafy.application.controller.response;

import com.main.estocafy.application.domain.enums.PlanType;
import lombok.Data;

import java.util.UUID;

@Data
public class PlanResponse {
    private UUID id;
    private PlanType type;
    private boolean ativo;
}
