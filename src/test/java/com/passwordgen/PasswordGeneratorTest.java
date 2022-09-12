package com.passwordgen;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Unit test for PasswordGenerator
 */
public class PasswordGeneratorTest {
    @Test
    public void shouldGenerateExpectedLength() {
        for (int i = 1; i <= 100; i++) {
            PasswordGenerator generator = new PasswordGenerator(i, Ascii.lower);
            assertEquals(i, generator.generate().length());
        }
    }

    @Test
    public void shouldUseCorrectCharsets() {
        PasswordGenerator generator = new PasswordGenerator(100, Ascii.digits);
        String password = generator.generate();

        for (String chr : (Ascii.upper + Ascii.lower + Ascii.punctuation).split("")) {
            assertFalse(password.contains(chr));
        }

        generator = new PasswordGenerator(100, Ascii.lower + Ascii.digits);
        password  = generator.generate();

        for (String chr : (Ascii.upper + Ascii.punctuation).split("")) {
            assertFalse(password.contains(chr));
        }
    }
}
