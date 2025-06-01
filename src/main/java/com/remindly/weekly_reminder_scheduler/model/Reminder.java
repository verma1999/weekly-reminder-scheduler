package com.remindly.weekly_reminder_scheduler.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalTime time;
    private String recipient;
    private boolean active;

    @Enumerated(EnumType.STRING)
    private RepeatType repeatType;

    @ElementCollection(targetClass = DayOfWeek.class)
    @Enumerated(EnumType.STRING)
    private List<DayOfWeek> daysOfWeek;

    private boolean emailPreferred;
    private boolean whatsappPreferred;
}