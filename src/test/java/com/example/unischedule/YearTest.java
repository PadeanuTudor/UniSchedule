package com.example.unischedule;

import com.example.unischedule.model.Year;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class YearTest {
    @Test
    void testYearConstructor() {
        Year year = new Year();
        assertNotNull(year);
    }
}
