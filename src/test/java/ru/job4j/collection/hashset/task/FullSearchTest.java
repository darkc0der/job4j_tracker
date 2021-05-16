package ru.job4j.collection.hashset.task;
/* 1. Уникальные задачи. [#393842] */
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        List<Task> list = Arrays.asList(
                new Task("1", "Pavel"),
                new Task("5", "Ivan"),
                new Task("5", "Petr")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "5"));
        assertThat(FullSearch.extractNumber(list), is(expected));
    }
}