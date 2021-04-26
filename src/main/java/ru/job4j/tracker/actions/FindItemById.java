package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class FindItemById implements UserAction {
    private String name = "Find item by Id";

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        System.out.println(item != null ? item : "Request with id not found");
        return true;
    }
}
