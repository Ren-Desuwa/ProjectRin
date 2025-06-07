package app.utils;

public class Util {

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static int parseIntSafe(String s, int defaultValue) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static double parseDoubleSafe(String s, double defaultValue) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static <T> boolean arrayContains(T[] array, T value) {
        if (array == null) return false;
        for (T item : array) {
            if (item == null && value == null) return true;
            if (item != null && item.equals(value)) return true;
        }
        return false;
    }
}
