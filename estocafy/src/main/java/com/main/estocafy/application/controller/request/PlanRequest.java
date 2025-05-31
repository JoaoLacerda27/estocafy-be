package com.main.estocafy.application.controller.request;

import com.main.estocafy.application.domain.enums.PlanType;
import lombok.Data;

@Data
public class PlanRequest {
    private PlanType type;
}
