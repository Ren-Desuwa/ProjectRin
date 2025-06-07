package app.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Debbuger {
    private static boolean enabled = true;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void setEnabled(boolean isEnabled) {
        enabled = isEnabled;
    }

    private static String getTimestamp() {
        return LocalDateTime.now().format(formatter);
    }

    public static void log(String message) {
        if (enabled) {
            System.out.println("[DEBUG] " + getTimestamp() + " - " + message);
        }
    }

    public static void logInfo(String message) {
        if (enabled) {
            System.out.println("[INFO] " + getTimestamp() + " - " + message);
        }
    }

    public static void logWarn(String message) {
        if (enabled) {
            System.out.println("[WARN] " + getTimestamp() + " - " + message);
        }
    }

    public static void logError(String message) {
        if (enabled) {
            System.err.println("[ERROR] " + getTimestamp() + " - " + message);
        }
    }
    
    public static void print(Object... args) {
        if (enabled) {
            StringBuilder sb = new StringBuilder();
            for (Object arg : args) {
                sb.append(arg);
            }
            System.out.println(sb.toString());
        }
    }
}
