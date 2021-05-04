package ru.job4j.ooa;

public class FinalUsage {
    static final String FULL_NAME = "Pavel Ivanv";
    private static final int DEFAULT_STORE_CAPACITY = 100;

    public static void main(String[] args) {
        final String NAME = "Pavel";
        System.out.println(NAME);
        // NAME = "Ivan"; // error var is final

        System.out.println(FULL_NAME);
        // FULL_NAME = "Petya Ivanov"; error var is final
    }
}
