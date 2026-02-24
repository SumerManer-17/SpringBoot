package com.sumer.FirstProject.Impl;

import com.sumer.FirstProject.NotificationService;

public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending Email..."+message);
    }
}
