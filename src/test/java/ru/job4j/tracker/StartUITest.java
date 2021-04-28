package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.*;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"Pavel"});
        new CreateItem().execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Pavel");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "replaced item"
        };
        new ReplaceItem().execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId())
        };
        UserAction action = new DeleteItem();
        action.execute(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
        //assertNull(deleted);
    }

    @Test
    public void whenCreate() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        UserAction[] actions = {
                new CreateItem(),
                new ExitProgram()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item 1"));
        Input input = new StubInput(
                new String[] {"0", "1", "Item 2", "1"}
        );
        UserAction[] actions = {
                new ReplaceItem(),
                new ExitProgram()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Item 2"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        item = tracker.add(item);
        Input input = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteItem(),
                new ExitProgram()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}