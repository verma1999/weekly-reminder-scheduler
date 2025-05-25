package com.remindly.weekly_reminder_scheduler.service;

import com.remindly.weekly_reminder_scheduler.model.Reminder;

import java.util.List;

public interface ReminderService {
    public Reminder save(Reminder reminder);
    public List<Reminder> getAll();
}
