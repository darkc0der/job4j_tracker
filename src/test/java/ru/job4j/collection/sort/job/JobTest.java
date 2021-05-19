package ru.job4j.collection.sort.job;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenComparatorByNameAndPriorityDesc() {
        Comparator<Job> comNamePriority = new JobDescByName().thenComparing(
                new JobDescByPriority());
        int rsl = comNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );

        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityAsc() {
        Comparator<Job> comNamePriority = new JobAscByName().thenComparing(
                new JobAscByPriority());
        int rsl = comNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );

        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorJobDescByName() {
        Comparator<Job> comNamePriority = new JobDescByName();
        int rsl = comNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );

        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorJobDescByPriority() {
        Comparator<Job> comNamePriority = new JobDescByPriority();
        int rsl = comNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );

        assertThat(rsl, greaterThan(0));
    }
}