package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;
public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                output.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action  = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        output.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            output.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(new ConsoleInput(), output);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItem(output),
                new ShowItemsAll(output),
                new ReplaceItem(output),
                new DeleteItem(output),
                new FindItemById(output),
                new FindItemsByName(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
