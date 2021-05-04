package ru.job4j.ooa;

public class Main {
    public static void main(String[] args) {
        final User FIRST_USER = new User("Pavel", 23);
        System.out.println("Вывод в консоль до изменения");
        System.out.println(FIRST_USER);

        FIRST_USER.setName("Ivan");
        FIRST_USER.setAge(42);
        System.out.println("Вывод в консоль после изменения");
        System.out.println(FIRST_USER);

        // FIRST_USER = new User("Kolya", 35); // error var is final
        // but the internal state can be changed
    }
}
