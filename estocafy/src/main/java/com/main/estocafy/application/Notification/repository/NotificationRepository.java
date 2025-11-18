package com.main.estocafy.application.Notification.repository;

import com.main.estocafy.application.Notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID>, QuerydslPredicateExecutor<Notification> {
}

