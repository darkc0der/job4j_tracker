package ru.job4j.collection.sort.job;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {

    @Override
    public int compare(Job first, Job second) {
        return second.getName().compareTo(first.getName());
    }
}
