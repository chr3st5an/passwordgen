package com.passwordgen;


public class App {
    static final String usageMessage = "💡 usage: length [OPTIONS]";

    public static void main(String[] args) {
        String charset = Ascii.lower + Ascii.upper;

        for (String arg : args) {
            if (arg.equals("-h") || arg.equals("--help")) {
                printHelpAndExit();
            } else if (arg.equals("-d")) {  // flag: digits
                charset += Ascii.digits;
            } else if (arg.equals("-p")) {  // flag: punctuation
                charset += Ascii.punctuation;
            }
        }

        PasswordGenerator gen = new PasswordGenerator(getPasswordLength(args), charset);

        System.out.println("🍰 Your password 🍰");
        System.out.println(gen.generatePassword());
    }

    public static int getPasswordLength(String[] args) {
        int passwordLength = 0;

        try {
            passwordLength = Integer.valueOf(args[0]);
        } catch (Exception e) {
            System.out.println(usageMessage);
            System.exit(1);
        }

        return passwordLength;
    }

    public static void printHelpAndExit() {
        System.out.println(usageMessage + "\n");
        System.out.println("Generate a password containing lowercase and uppercase characters\n");
        System.out.println("positional arguments:\n length\t\tThe desired password length\n");
        System.out.println("optional arguments:\n -d\t\tInclude digits in the password");
        System.out.println(" -p\t\tInclude punctuation characters in the password");

        System.exit(0);
    }
}
