package com.main.estocafy.application.Plan.controller.response;

import com.main.estocafy.application.Plan.enums.PlanType;
import lombok.Data;

import java.util.UUID;

@Data
public class PlanResponse {
    private UUID id;
    private PlanType type;
    private boolean active;
}

