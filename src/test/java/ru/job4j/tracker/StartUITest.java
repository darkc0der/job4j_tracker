package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.*;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"Pavel"}, output);
        Input validateInput = new ValidateInput(input, output);
        new CreateItem(output).execute(validateInput, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Pavel");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "replaced item"
        };
        Input validateInput = new ValidateInput(new StubInput(answers, output), output);
        new ReplaceItem(output).execute(validateInput, tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId())
        };
        UserAction action = new DeleteItem(output);
        Input validateInput = new ValidateInput(new StubInput(answers, output), output);
        action.execute(validateInput, tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
        //assertNull(deleted);
    }

    @Test
    public void whenCreate() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input input = new StubInput(
                new String[] {"0", "Item name", "1"},
                output
        );
        UserAction[] actions = {
                new CreateItem(output),
                new ExitProgram(output)
        };
        Input validateInput = new ValidateInput(input, output);
        new StartUI(output).init(validateInput, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplace() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item 1"));
        Input input = new StubInput(
                new String[] {"0", "1", "Item 2", "1"},
                output
        );
        UserAction[] actions = {
                new ReplaceItem(output),
                new ExitProgram(output)
        };
        Input validateInput = new ValidateInput(input, output);
        new StartUI(output).init(validateInput, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Item 2"));
    }

    @Test
    public void whenDelete() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        item = tracker.add(item);
        Input input = new StubInput(
                new String[] {"0", "1", "1"},
                output
        );
        Input validateInput = new ValidateInput(input, output);
        UserAction[] actions = {
                new DeleteItem(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(validateInput, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExecuteExit() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[] {"0"}, output);
        Tracker tracker = new Tracker();
        UserAction[] action = {
                new ExitProgram(output)
        };
        Input validateInput = new ValidateInput(input, output);
        new StartUI(output).init(validateInput, tracker, action);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Exit Program ===" + System.lineSeparator())
        );
    }

    @Test
    public void whenExecuteCreate() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "New Item", "1"},
                output
        );
        Input validateInput = new ValidateInput(input, output);
        UserAction[] actions = {
                new CreateItem(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(validateInput, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Create a new Item ====" + System.lineSeparator()
                + "Enter name: " + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Exit Program ===" + System.lineSeparator())
        );
    }

    @Test
    public void whenExecuteDelete() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "New item", "1", "1", "2"},
                output
        );
        UserAction[] actions = {
                new CreateItem(output),
                new DeleteItem(output),
                new ExitProgram(output)
        };
        Input validateInput = new ValidateInput(input, output);
        new StartUI(output).init(validateInput, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Delete item" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Create a new Item ====" + System.lineSeparator()
                + "Enter name: " + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Delete item" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Delete item ===" + System.lineSeparator()
                + "Enter id: " + System.lineSeparator()
                + "Item deleted" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Delete item" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Exit Program ===" + System.lineSeparator())
        );
    }

    @Test
    public void whenExecuteFindItemById() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "New item", "1", "1", "2"},
                output
        );
        Input validateInput = new ValidateInput(input, output);
        UserAction[] actions = {
                new CreateItem(output),
                new FindItemById(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(validateInput, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Find item by Id" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Create a new Item ====" + System.lineSeparator()
                + "Enter name: " + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Find item by Id" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Find item by Id ===" + System.lineSeparator()
                + "Enter id: " + System.lineSeparator()
                + "Item{id=1, name='New item', created=03-05-2021}" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Find item by Id" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Exit Program ===" + System.lineSeparator())
        );
    }

    @Test
    public void whenExecuteFindItemByName() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "New Item", "1", "New Item", "2"},
                output
        );

        Input validateInput = new ValidateInput(input, output);

        UserAction[] actions = {
                new CreateItem(output),
                new FindItemsByName(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(validateInput, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Find items by name" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Create a new Item ====" + System.lineSeparator()
                + "Enter name: " + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Find items by name" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Find items by name ===" + System.lineSeparator()
                + "Enter name: " + System.lineSeparator()
                + "Item{id=1, name='New Item', created=03-05-2021}" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Find items by name" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Exit Program ===" + System.lineSeparator())
        );
    }

    @Test
    public void whenExecuteReplace() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "New Item", "1", "1", "New Item 2", "2"},
                output
        );
        Input validateInput = new ValidateInput(input, output);
        UserAction[] actions = {
                new CreateItem(output),
                new ReplaceItem(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(validateInput, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Edit item" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Create a new Item ====" + System.lineSeparator()
                + "Enter name: " + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Edit item" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Edit item ===" + System.lineSeparator()
                + "Enter id: " + System.lineSeparator()
                + "Enter name: " + System.lineSeparator()
                + "Item is replace" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Edit item" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Exit Program ===" + System.lineSeparator())
        );
    }

    @Test
    public void whenExecuteShowItemAll() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "New Item 1", "0", "New Item 2", "1", "2"},
                output
        );
        Input validateInput = new ValidateInput(input, output);
        UserAction[] actions = {
                new CreateItem(output),
                new ShowItemsAll(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(validateInput, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Create a new Item ====" + System.lineSeparator()
                + "Enter name: " + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Create a new Item ====" + System.lineSeparator()
                + "Enter name: " + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Show all items ===" + System.lineSeparator()
                + "Item{id=1, name='New Item 1', created=03-05-2021}" + System.lineSeparator()
                + "Item{id=2, name='New Item 2', created=03-05-2021}" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()
                + "2. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Exit Program ===" + System.lineSeparator())
        );
    }

    @Test
    public void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[] {"-1", "0"}, output);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgram(output)
        };
        Input validateInput = new ValidateInput(input, output);
        new StartUI(output).init(validateInput, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "Wrong input, you can select: 0 .. 0" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Exit Program ===" + System.lineSeparator()
        ));
    }
}








