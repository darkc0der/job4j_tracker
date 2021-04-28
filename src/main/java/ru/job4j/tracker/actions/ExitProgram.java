package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class ExitProgram implements UserAction {
    private String name = "Exit Program";
    private final Output out;

    public ExitProgram(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Exit Program ===");
        return false;
    }
}
