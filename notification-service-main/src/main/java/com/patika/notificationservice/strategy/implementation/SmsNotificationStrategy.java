package com.patika.notificationservice.strategy.implementation;

import com.patika.notificationservice.dto.NotificationDTO;
import com.patika.notificationservice.dto.enums.NotificationType;
import com.patika.notificationservice.strategy.NotificationStrategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SmsNotificationStrategy implements NotificationStrategy {
    @Override
    public void sendMessage(NotificationDTO notification) {
        log.info(notification.getMessage()+" send to " + notification.getTo());
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.SMS;
    }
}
