package com.patika.notificationservice.strategy;

import com.patika.notificationservice.dto.NotificationDTO;
import com.patika.notificationservice.dto.enums.NotificationType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@AllArgsConstructor
@Component
@Slf4j
public class NotificationContext {
    private final Map<NotificationType, NotificationStrategy> sendNotificationByType;

    public void sendMessage(NotificationDTO notification) {
        NotificationStrategy notificationStrategy = sendNotificationByType.getOrDefault(notification.getNotificationType(), null);
        notificationStrategy.sendMessage(notification);
    }
}
