package com.example.unischedule.model;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ScheduleEntryDTO {
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private String room;
    private Long yearId;
    private Long courseId;
    private Long instructorId;
}