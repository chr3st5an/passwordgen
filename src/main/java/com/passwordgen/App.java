package com.passwordgen;


public class App {
    static final String usageMessage = "💡 usage: length [OPTIONS]";

    public static void main(String[] args) {
        String  charset     = Ascii.lower + Ascii.upper;
        boolean entropyFlag = false;

        for (String arg : args) {
            if (arg.equals("-h") || arg.equals("--help")) {
                printHelpAndExit();
            } else if (arg.equals("-d")) {  // flag: digits
                charset += Ascii.digits;
            } else if (arg.equals("-p")) {  // flag: punctuation
                charset += Ascii.punctuation;
            } else if (arg.equals("-e")) {  // flag: entropy
                entropyFlag = true;
            }
        }

        PasswordGenerator gen = new PasswordGenerator(getPasswordLength(args), charset);
        String password = gen.generatePassword();

        System.out.print(ConsoleColors.CYAN + password + ConsoleColors.RESET);

        if (entropyFlag) {
            double entropy = calculateEntropy(password, charset);
            String color   = "";

            if (entropy < 50) {
                color = ConsoleColors.RED_BOLD;
            } else if (entropy < 100) {
                color = ConsoleColors.YELLOW_BOLD;
            } else {
                color = ConsoleColors.GREEN_BOLD;
            }

            System.out.printf("\t%s🛡 ENTROPY: %.2f 🛡%s", color, entropy, ConsoleColors.RESET);
        }
    }

    /**
     * Parses the desired password length from
     * the args list given by the CLI.
     *
     * @param args the args provided by the CLI
     * @return the length
     */
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

    /**
     * Calculates the given passwords entropy with the
     * given formula: log_2(n).
     * Where n is sum of all possible password combinations.
     *
     * @param password the generated password
     * @param charset  the charset that got used to generate
     *                 the password
     * @return the entropy
     */
    public static double calculateEntropy(String password, String charset) {
        double combinations = 0;

        // ∑ = l ^ i,  l = length of charset
        for (int i = 1; i <= password.length(); i++) {
            combinations += Math.pow(charset.length(), i);
        }

        // Calculating log base 2
        return Math.log(combinations) / Math.log(2);
    }

    /**
     * Print a help message and exit the program.
     */
    public static void printHelpAndExit() {
        System.out.println(usageMessage + "\n");
        System.out.println("Generate a password containing lowercase and uppercase characters\n");
        System.out.println("positional arguments:\n length\t\tThe desired password length\n");
        System.out.println("optional arguments:\n -d\t\tInclude digits in the password");
        System.out.println(" -p\t\tInclude punctuation characters in the password");

        System.exit(0);
    }
}
