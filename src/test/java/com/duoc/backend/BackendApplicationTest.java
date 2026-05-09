package com.duoc.backend;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class BackendApplicationTest {

    @Test
    void shouldLoadApplication() {

        BackendApplication app = new BackendApplication();

        assertNotNull(app);
    }
}