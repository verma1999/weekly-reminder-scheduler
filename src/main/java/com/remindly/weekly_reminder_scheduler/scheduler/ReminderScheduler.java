package com.remindly.weekly_reminder_scheduler.scheduler;

import com.remindly.weekly_reminder_scheduler.model.Reminder;
import com.remindly.weekly_reminder_scheduler.service.EmailService;
import com.remindly.weekly_reminder_scheduler.service.ReminderService;
import com.remindly.weekly_reminder_scheduler.service.WhatsAppService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReminderScheduler {
    private final ReminderService reminderService;
    private final EmailService emailService;
    private final WhatsAppService whatsAppService;

    public ReminderScheduler(ReminderService reminderService, EmailService emailService, WhatsAppService whatsAppService) {
        this.reminderService = reminderService;
        this.emailService = emailService;
        this.whatsAppService = whatsAppService;
    }

    @Scheduled(cron = "0 * * * * *") // Every minute
    public void checkAndSendReminders() {
        List<Reminder> dueReminders = reminderService.getDueReminders();
        for (Reminder reminder : dueReminders) {
            if (reminder.isEmailPreferred()) {
                emailService.sendReminderEmail(reminder.getRecipient(), reminder.getTitle(), reminder.getDescription());
            }
            if (reminder.isWhatsappPreferred()) {
                whatsAppService.sendWhatsAppMessage(reminder.getRecipient(), reminder.getDescription());
            }
            System.out.println("Sending reminder to: " + reminder.getRecipient() + ", title: " + reminder.getTitle());
            // integrate with email or WhatsApp APIs here
        }
    }
}
