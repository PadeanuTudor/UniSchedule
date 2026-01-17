package com.example.unischedule;

import com.example.unischedule.model.Admin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    @Test
    void testAdminConstructor() {
        Admin admin = new Admin();
        assertNotNull(admin);
    }

}
