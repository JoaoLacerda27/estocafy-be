package com.main.estocafy.application.Plan.controller.request;

import com.main.estocafy.application.Plan.enums.PlanType;
import lombok.Data;

@Data
public class PlanRequest {
    private PlanType type;
}

