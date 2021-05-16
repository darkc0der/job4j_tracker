package ru.job4j.collection.hashset.task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public static Set<String> extractNumber(List<Task> list) {
        Set<String> rsl = new HashSet<>();
        for (Task task : list) {
            rsl.add(task.getNumber());
        }
        return rsl;
    }
}
