package com.duoc.backend;

import java.security.Key;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class ConstantsTest {

    @Test
    void shouldGenerateSigningKey() {

        Key key =
            Constants.getSigningKey(
                Constants.SUPER_SECRET_KEY);

        assertNotNull(key);
    }

    @Test
    void shouldGenerateSigningKeyB64() {

        Key key =
            Constants.getSigningKeyB64(
                Constants.SUPER_SECRET_KEY);

        assertNotNull(key);
    }
}