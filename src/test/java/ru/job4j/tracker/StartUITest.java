package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.CreateItem;
import ru.job4j.tracker.actions.DeleteItem;
import ru.job4j.tracker.actions.ReplaceItem;
import ru.job4j.tracker.actions.UserAction;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Input input = new StubInput(new String[] {"Pavel"});
        Tracker tracker = new Tracker();
        UserAction action = new CreateItem();
        action.execute(input, tracker);
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
        UserAction action = new ReplaceItem();
        action.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void deleteItem() {
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
}