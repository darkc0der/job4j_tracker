package ru.job4j.collection.sort.job;

import java.util.*;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);

        Collections.sort(jobs, new JobAscByNameLn());
        System.out.println(jobs);

        Comparator<Job> comp = new JobAscByNameLn();
        Comparator<Job> comp2 = new JobAscByName();
        Comparator<Job> comp3 = new JobAscByPriority();
        Comparator<Job> comp4 = new JobDescByNameLn();
        Comparator<Job> comp5 = new JobDescByName();
        Comparator<Job> comp6 = new JobDescByPriority();

        Collections.sort(jobs, comp.thenComparing(comp2.thenComparing(comp3.thenComparing(comp4))));
        Collections.sort(jobs, Comparator.reverseOrder());
        System.out.println(jobs);
    }
}
