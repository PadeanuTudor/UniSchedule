package com.example.unischedule;

import com.example.unischedule.model.ScheduleEntry;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class ScheduleEntryTest {

    @Test
    void testScheduleConstructor() {
        ScheduleEntry entry = new ScheduleEntry();
        assertNotNull(entry);
    }

    @Test
    void testTimeFunctionality() {
        ScheduleEntry entry = new ScheduleEntry();
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(10, 30);

        entry.setStartTime(start);
        entry.setEndTime(end);

        assertTrue(entry.getEndTime().isAfter(entry.getStartTime()), "End time must be after start time");
    }
}