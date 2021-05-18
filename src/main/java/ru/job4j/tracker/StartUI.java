package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;
import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                output.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action  = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            output.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(new ConsoleInput(), output);
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new CreateItem(output),
                new ShowItemsAll(output),
                new ReplaceItem(output),
                new DeleteItem(output),
                new FindItemById(output),
                new FindItemsByName(output),
                new Sort(output),
                new SortReverse(output),
                new ExitProgram(output)
        );
        new StartUI(output).init(input, tracker, actions);
    }
}
