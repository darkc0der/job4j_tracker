package ru.job4j.collection.sort.job;

import java.util.Comparator;

public class JobAscByPriority implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return Integer.compare(first.getPriority(), second.getPriority());
    }
}
