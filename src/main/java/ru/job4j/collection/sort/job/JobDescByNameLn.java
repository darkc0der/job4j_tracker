package ru.job4j.collection.sort.job;

import java.util.Comparator;

public class JobDescByNameLn implements Comparator<Job> {

    @Override
    public int compare(Job first, Job second) {
        return Integer.compare(second.getName().length(), first.getName().length());
    }
}
