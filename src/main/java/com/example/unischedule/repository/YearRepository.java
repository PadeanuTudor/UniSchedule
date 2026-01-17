package com.example.unischedule.repository;

import com.example.unischedule.model.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface YearRepository extends JpaRepository<Year, Long> {
    List<Year> findBySpecialtyId(Long specialtyId);
}