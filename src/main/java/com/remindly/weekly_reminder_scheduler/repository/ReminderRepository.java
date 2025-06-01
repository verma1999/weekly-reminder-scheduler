package com.remindly.weekly_reminder_scheduler.repository;

import com.remindly.weekly_reminder_scheduler.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByTime(LocalTime time);
}