package com.remindly.weekly_reminder_scheduler.service;

public interface EmailService {
    void sendReminderEmail(String to, String subject, String text);
}
