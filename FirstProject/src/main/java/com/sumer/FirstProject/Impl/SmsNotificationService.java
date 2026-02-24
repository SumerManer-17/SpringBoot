package com.sumer.FirstProject.Impl;

import com.sumer.FirstProject.NotificationService;

public class SmsNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Sms is sending..."+message);
    }
}
