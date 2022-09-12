package com.passwordgen;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Unit test for App
 */
public class AppTest {
    @Test
    public void shouldReturnTheCorrectNumber() {
        for (int i = 0; i <= 100; i++) {
            String[] args = {String.valueOf(i)};
            assertEquals(i, App.getPasswordLength(args));
        }
    }
}
