package com.passwordgen;

import java.util.Random;


interface Generator {
    String generate();
}

/**
 * A Generator which generates passwords
 *
 * @author chr3st5an
 * @version 1.0
 */
public class PasswordGenerator implements Generator {
    private final int length;
    private final String[] charset;

    /**
     * Create a Generator instance
     *
     * @param length  the desired password length
     * @param charset the charset that will get used to generate
     *                the password
     */
    public PasswordGenerator(int length, String[] charset) {
        this.length  = length;
        this.charset = charset;
    }

    /**
     * Create a Generator instance
     *
     * @param length  the desired password length
     * @param charset the charset that will get used to generate
     *                the password
     */
    public PasswordGenerator(int length, String charset) {
        this.length  = length;
        this.charset = charset.split("");
    }

    public String toString() {
        return String.format("%s(%d, \"%s\")", this.getClass().getName(), length, String.join("", charset));
    }

    /**
     * Generate a new password based on the parameters
     * given by the constructor
     *
     * @return the generated password
     */
    public String generatePassword() {
        Random random   = new Random();
        String password = "";

        for (int i = 0; i < length; i++) {
            password += charset[random.nextInt(charset.length)];
        }

        return password;
    }

    /**
     * Alias for <code> generatePassword </code>
     */
    public String generate() {
        return generatePassword();
    }

    /**
     * @return the password length that the generator will generate
     */
    public int getPasswordLength() {
        return length;
    }

    /**
     * @return the charset that the generator uses
     */
    public String[] getCharset() {
        return charset;
    }
}
