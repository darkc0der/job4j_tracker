package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public class ExitProgram implements UserAction {
    private String name = "Exit Program";

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Exit Program ===");
        return false;
    }
}
