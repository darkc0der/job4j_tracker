package ru.job4j.collection.treeset;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSort {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(1);
        System.out.println(numbers);

        Set<String> strings = new TreeSet<>(Collections.reverseOrder());
        strings.add("c");
        strings.add("z");
        strings.add("a");
        strings.add("b");
        System.out.println(strings);
    }
}
