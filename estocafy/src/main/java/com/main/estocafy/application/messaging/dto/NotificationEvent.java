package com.main.estocafy.application.messaging.dto;

import java.util.Map;
import java.util.UUID;

import com.main.estocafy.application.domain.enums.NotificationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationEvent {
    private UUID notificationId;
    private NotificationType type; 
    private String message;
    private String recipientEmail;
    private UUID tenantId;
    private UUID branchId;
    private UUID productId;
    private Map<String, Object> payload;
}
