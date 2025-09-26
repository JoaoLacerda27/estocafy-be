package com.main.estocafy.application.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.estocafy.application.domain.enums.NotificationStatus;
import com.main.estocafy.application.domain.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    List<Notification> findByStatus(NotificationStatus status); 
}
