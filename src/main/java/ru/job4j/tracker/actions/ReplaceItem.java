package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class ReplaceItem implements UserAction {
    private String name = "Edit item";
    private final Output out;

    public ReplaceItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        item.setId(id);
        out.println(tracker.replace(id, item) ? "Item is replace" : "Item isn't replace");
        return true;
    }
}
