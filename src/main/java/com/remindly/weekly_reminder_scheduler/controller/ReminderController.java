package com.remindly.weekly_reminder_scheduler.controller;

import com.remindly.weekly_reminder_scheduler.model.Reminder;
import com.remindly.weekly_reminder_scheduler.service.ReminderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @PostMapping
    public Reminder create(@RequestBody Reminder reminder) {
        return reminderService.save(reminder);
    }

    @GetMapping
    public List<Reminder> getAll() {
        return reminderService.getAll();
    }
}
