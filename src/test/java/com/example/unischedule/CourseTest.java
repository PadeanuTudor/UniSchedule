package com.example.unischedule;

import com.example.unischedule.model.Course;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void testCourseData() {
        Course course = new Course();

        course.setName("French Language");
        course.setCode("FL");

        assertEquals("French Language", course.getName());
        assertEquals("FL", course.getCode());
    }
}