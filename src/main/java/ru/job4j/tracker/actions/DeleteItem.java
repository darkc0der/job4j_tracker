package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class DeleteItem implements UserAction {
    private String name = "Delete item";
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        out.println(tracker.delete(id) ? "Item deleted" : "Item isn't deleted");
        return true;
    }
}
