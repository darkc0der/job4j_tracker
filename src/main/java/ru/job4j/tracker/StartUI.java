package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormatter = currentLocalDateTime.format(formatter);
        System.out.println(currentDateTimeFormatter);

        Tracker tr = new Tracker();
        Item item = new Item("Test");
        Item item2 = new Item("Maksim");
        Item item3 = new Item("Nadya");
        Item item4 = new Item("Nadya");
        Item item5 = new Item("Nadya");

        tr.add(item);
        tr.add(item2);
        tr.add(item3);
        tr.add(item4);
        tr.add(item5);

        Item item6 = tr.findById(2);
        System.out.println(item6.getName());

        Item[] items = tr.findByName("Nadya");
        for (Item i : items) {
            System.out.println(i.getName());
        }
    }
}
