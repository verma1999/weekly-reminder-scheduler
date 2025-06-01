package com.remindly.weekly_reminder_scheduler.service;

import com.remindly.weekly_reminder_scheduler.model.Reminder;

import java.util.List;

public interface ReminderService {
    Reminder save(Reminder reminder);
    List<Reminder> getAll();
    List<Reminder> getDueReminders();
}
