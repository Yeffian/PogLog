package io.github.yeffycodegit.poglog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static io.github.yeffycodegit.poglog.ColorConstants.*;


public class PogLogger {
    private final boolean logToFile;
    private final FileWriter fileWriter;
    private BufferedWriter writer;


    public PogLogger(boolean logToFile) throws IOException {
        this.logToFile = logToFile;
        String filename = "app-logs.txt";

        fileWriter = new FileWriter(filename);
        writer = new BufferedWriter(fileWriter);
    }

    public void success(Object msg) throws IOException {
        if (logToFile) {
            writer.write("[SUCCESS] " + msg.toString() + "\n");
            writer.flush();
            return;
        }

        System.out.printf(GREEN + "[SUCCESS] %s%n" + RESET, msg.toString());
    }

    public void info(Object msg) throws IOException {
        if (logToFile) {
            writer.write("[INFO] " + msg.toString() + "\n");
            writer.flush();
            return;
        }

        System.out.printf(BLUE + "[INFO] %s%n" + RESET, msg.toString());
    }

    public void warn(Object msg) throws IOException {
        if (logToFile) {
            writer.write("[WARN] " + msg.toString() + "\n");
            writer.flush();
            return;
        }

        System.out.printf(YELLOW + "[WARN] %s%n" + RESET, msg.toString());
    }

    public void error(Object msg) throws IOException {
        if (logToFile) {
            writer.write("[ERROR] " + msg.toString() + "\n");
            writer.flush();
            return;
        }

        System.out.printf(ColorConstants.RED + "[ERROR] %s%n" + ColorConstants.RESET, msg.toString());
    }

    public void error(Exception e) throws IOException {
        if (logToFile) {
            writer.write("[ERROR] " + e.toString() + "\n");
            writer.write("     [STACK TRACE] " + Arrays.toString(e.getStackTrace()) + "\n");
            writer.write("     [CAUSE] " + e.getCause() + "\n");
            writer.flush();
            return;
        }

        System.out.printf(RED + "[ERROR] %s%n" + RESET, e.toString());
        System.out.printf(RED + "    [STACK TRACE] %s%n" + RESET, Arrays.toString(e.getStackTrace()));
        System.out.printf(RED + "    [CAUSE] %s%n" + RESET, e.getCause());
    }
}
