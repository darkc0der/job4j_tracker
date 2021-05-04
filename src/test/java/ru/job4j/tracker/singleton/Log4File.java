package ru.job4j.tracker.singleton;

public final class Log4File {
    private static Log4File instance = null;
    private String[] messages = new String[1000];
    private int index = 0;

    private Log4File() {
    }

    public void add(String message) {
        messages[index++] = message;
    }

    public String getMessage() {
        return messages[--index];
    }

    public static Log4File getInstance() {
        if (instance == null) {
            instance = new Log4File();
        }
        return instance;
    }

    public static void main(String[] args) {
        Log4File lf = Log4File.getInstance();
        lf.add("Hello");
        System.out.println(lf.getMessage());
    }
}
