package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

import java.util.Collections;
import java.util.Comparator;

public class SortReverse implements UserAction, Comparator<Item> {
    private String name = "Sorted Reverse by Name";
    private final Output out;

    public SortReverse(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Sort In Descending ===");
        Collections.sort(tracker.getItems(), new SortReverse(out));
        Collections.reverse(tracker.getItems());
        return true;
    }

    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
