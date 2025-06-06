package com.main.estocafy.shared.security.service;

import com.main.estocafy.application.domain.enums.PlanType;
import com.main.estocafy.shared.security.model.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service("planSecurityService")
public class PlanSecurityService {

    public boolean hasPlan(Authentication authentication, String planType) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }
        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        PlanType userPlanType = userDetails.getPlan().getType();

        return userPlanType.name().equalsIgnoreCase(planType);
    }
}
