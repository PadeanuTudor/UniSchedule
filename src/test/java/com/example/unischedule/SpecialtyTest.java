package com.example.unischedule;

import com.example.unischedule.model.Specialty;
import com.example.unischedule.model.Faculty;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SpecialtyTest {
    @Test
    void testSpecialtyConstructor() {
        Specialty specialty = new Specialty();
        assertNotNull(specialty);
    }

    @Test
    void testSpecialtyFacultyLink() {
        Specialty specialty = new Specialty();
        Faculty faculty = new Faculty();
        faculty.setName("Science");

        specialty.setFaculty(faculty);
        assertEquals("Science", specialty.getFaculty().getName());
    }
}
