package com.remindly.weekly_reminder_scheduler.repository;

import com.remindly.weekly_reminder_scheduler.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
}