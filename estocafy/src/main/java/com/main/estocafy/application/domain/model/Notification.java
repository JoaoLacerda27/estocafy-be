package com.main.estocafy.application.domain.model;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.main.estocafy.application.domain.enums.NotificationStatus;
import com.main.estocafy.application.domain.enums.NotificationType;
import com.main.estocafy.shared.model.ModelBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "notifications")
public class Notification extends ModelBase{
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2")
    @NotNull
    protected UUID id;

    @Column(nullable = true)
    private UUID tenantId;

    @Column(nullable = true)
    private UUID branchId;

    @Column(nullable = true)
    private UUID productId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private NotificationType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private NotificationStatus status;

    @Column(columnDefinition = "text")
    private String message;

    @Column(columnDefinition = "jsonb")
    private String payload;

    @Column(length = 255)
    private String recipientEmail;

    @Column
    private Instant sentAt;
}
