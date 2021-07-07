package io.github.yeffycodegit.poglog;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class PogLogger {
    private final boolean logToFile;
    private String filename;
    FileWriter fileWriter;

    // Define color constants
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public PogLogger(boolean logToFile) throws IOException {
        this.logToFile = logToFile;
        this.filename = "app-logs.txt";

        fileWriter = new FileWriter(filename);
    }

    public void success(Object msg) throws IOException {
        if (logToFile) {
            fileWriter.write(GREEN + "[SUCCESS] " + msg.toString() + RESET + "\n");
            fileWriter.flush();
            return;
        }

        System.out.printf(RED "[SUCCESS] %s%n" + RESET, msg.toString());
    }

    public void info(Object msg) throws IOException {
        if (logToFile) {
            fileWriter.write(CYAN + "[INFO] " + RESET + msg.toString() + "\n");
            fileWriter.flush();
            return;
        }

        System.out.printf(CYAN + "[INFO] " + RESET + "%s%n", msg.toString());
    }

    public void warn(Object msg) throws IOException {
        if (logToFile) {
            fileWriter.write(YELLOW + "[WARN] " + msg.toString() + RESET + "\n");
            fileWriter.flush();
            return;
        }

        System.out.printf(YELLOW + "[WARN] %s%n" + RESET, msg.toString());
    }

    public void error(Object msg) throws IOException {
        if (logToFile) {
            fileWriter.write(RED + "[ERROR] " + msg.toString() + RESET + "\n");
            fileWriter.flush();
            return;
        }

        System.out.printf(RED + "[ERROR] %s%n" + RESET, msg.toString());
    }

    public void error(Exception e) throws IOException {
        if (logToFile) {
            fileWriter.write(RED + "[ERROR] " + e.toString() + RESET + "\n");
            fileWriter.write(RED + "     [STACK TRACE] " + Arrays.toString(e.getStackTrace()) + RESET + "\n");
            fileWriter.write(BLUE + "     [CAUSE] " + e.getCause() + RESET + "\n");
            fileWriter.flush();
            return;
        }

        System.out.printf(RED + "[ERROR] %s%n" + RESET, e.toString());
        System.out.printf(RED + "    [STACK TRACE] %s%n" + RESET, Arrays.toString(e.getStackTrace()));
        System.out.printf(BLUE + "    [CAUSE] %s%n" + RESET, e.getCause());
    }
}
