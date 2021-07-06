package io.github.yeffycodegit.poglog;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class PogLogger {
    private final boolean logToFile;
    private String filename;
    FileWriter fileWriter;

    public PogLogger(boolean logToFile) throws IOException {
        this.logToFile = logToFile;
        this.filename = "app-logs.txt";

        fileWriter = new FileWriter(filename);
    }

    public void success(Object msg) throws IOException {
        if (logToFile) {
            fileWriter.write("[SUCCESS] " + msg.toString() + "\n");
            fileWriter.flush();
            return;
        }

        System.out.printf("[SUCCESS] %s%n", msg.toString());
    }

    public void info(Object msg) throws IOException {
        if (logToFile) {
            fileWriter.write("[INFO] " + msg.toString() + "\n");
            fileWriter.flush();
            return;
        }

        System.out.printf("[INFO] %s%n", msg.toString());
    }

    public void warn(Object msg) throws IOException {
        if (logToFile) {
            fileWriter.write("[WARN] " + msg.toString() + "\n");
            fileWriter.flush();
            return;
        }

        System.out.printf("[WARN] %s%n", msg.toString());
    }

    public void error(Object msg) throws IOException {
        if (logToFile) {
            fileWriter.write("[ERROR] " + msg.toString() + "\n");
            fileWriter.flush();
            return;
        }

        System.out.printf("[ERROR] %s%n", msg.toString());
    }

    public void error(Exception e) throws IOException {
        if (logToFile) {
            fileWriter.write("[ERROR] " + e.toString() + "\n");
            fileWriter.write("     [STACK TRACE] " + Arrays.toString(e.getStackTrace()) + "\n");
            fileWriter.write("     [CAUSE] " + e.getCause() + "\n");
            fileWriter.flush();
            return;
        }

        System.out.printf("[ERROR] %s%n", e.toString());
        System.out.printf("    [STACK TRACE] %s%n", Arrays.toString(e.getStackTrace()));
        System.out.printf("    [CAUSE] %s%n", e.getCause());
    }
}