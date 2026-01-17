package com.example.unischedule.repository;

import com.example.unischedule.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    List<Specialty> findByFacultyId(Long facultyId);
}