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
        new CreateItem(output).execute(input, tracker);
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
        new ReplaceItem(output).execute(new StubInput(answers, output), tracker);
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
        action.execute(new StubInput(answers, output), tracker);
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
        new StartUI(output).init(input, tracker, actions);
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
        new StartUI(output).init(input, tracker, actions);
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
        UserAction[] actions = {
                new DeleteItem(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[] {"0"}, output);
        Tracker tracker = new Tracker();
        UserAction[] action = {
                new ExitProgram(output)
        };
        new StartUI(output).init(input, tracker, action);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()
                + "Select: " + System.lineSeparator()
                + "=== Exit Program ===" + System.lineSeparator()
        ));
    }
}








