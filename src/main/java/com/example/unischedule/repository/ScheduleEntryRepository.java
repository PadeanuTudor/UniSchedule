package com.example.unischedule.repository;

import com.example.unischedule.model.ScheduleEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScheduleEntryRepository extends JpaRepository<ScheduleEntry, Long> {
    List<ScheduleEntry> findByYearId(Long yearId);
}