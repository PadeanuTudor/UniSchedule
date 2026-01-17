package com.example.unischedule;

import com.example.unischedule.model.Faculty;
import com.example.unischedule.model.Specialty;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class FacultyTest {

    @Test
    void testFacultyConstructorAndGetters() {
        Faculty faculty = new Faculty();
        assertNotNull(faculty, "Constructor should create an object");


        faculty.setName("Faculty of Mathematics");
        assertEquals("Faculty of Mathematics", faculty.getName());
    }

    @Test
    void testFacultySpecialtyRelationship() {
        Faculty faculty = new Faculty();
        faculty.setSpecialties(new ArrayList<>());

        Specialty spec = new Specialty();
        spec.setName("Faculty of Mathematics");
        faculty.getSpecialties().add(spec);

        assertEquals(1, faculty.getSpecialties().size());
        assertEquals("Faculty of Mathematics", faculty.getSpecialties().get(0).getName());
    }
}