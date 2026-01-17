package com.example.unischedule.repository;

import com.example.unischedule.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> { }