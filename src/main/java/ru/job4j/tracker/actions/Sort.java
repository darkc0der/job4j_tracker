package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.actions.UserAction;

import java.util.Collections;
import java.util.Comparator;

public class Sort implements UserAction, Comparator<Item> {
    private String name = "Sorted by Name";
    private final Output out;

    public Sort(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Sort In Ascending ===");
        Collections.sort(tracker.getItems(), new Sort(out));
        return true;
    }

    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
