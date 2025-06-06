package com.main.estocafy.shared.security.doc;

import com.main.estocafy.application.domain.model.Plan;
import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetails extends UserDetails {
    Plan getPlan();
}
