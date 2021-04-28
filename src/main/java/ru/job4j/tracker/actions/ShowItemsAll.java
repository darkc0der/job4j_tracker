package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class ShowItemsAll implements UserAction {
    private String name = "Show all items";
    private final Output out;

    public ShowItemsAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            out.println(item);
        }
        return true;
    }
}
