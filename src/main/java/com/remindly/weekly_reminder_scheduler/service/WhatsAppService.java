package com.remindly.weekly_reminder_scheduler.service;

public interface WhatsAppService {
    void sendWhatsAppMessage(String to, String messageBody);
}
