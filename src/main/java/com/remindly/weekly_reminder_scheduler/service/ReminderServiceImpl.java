package com.remindly.weekly_reminder_scheduler.service;

import com.remindly.weekly_reminder_scheduler.model.Reminder;
import com.remindly.weekly_reminder_scheduler.model.RepeatType;
import com.remindly.weekly_reminder_scheduler.repository.ReminderRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReminderServiceImpl implements ReminderService{
    private final ReminderRepository reminderRepository;

    public ReminderServiceImpl(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    @Override
    public Reminder save(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public List<Reminder> getAll() {
        return reminderRepository.findAll();
    }

    public List<Reminder> getDueReminders() {
        LocalTime nowTime = LocalTime.now().withSecond(0).withNano(0);
        DayOfWeek today = LocalDate.now().getDayOfWeek();

        return reminderRepository.findByTime(nowTime).stream()
                .filter(r -> r.isActive() && (
                        r.getRepeatType() == RepeatType.DAILY ||
                                (r.getRepeatType() == RepeatType.WEEKLY && r.getDaysOfWeek().contains(today)) ||
                                (r.getRepeatType() == RepeatType.CUSTOM && r.getDaysOfWeek().contains(today))
                ))
                .collect(Collectors.toList());
    }
}
