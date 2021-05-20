package ru.job4j.collection.sort.lexsort;

import java.util.Comparator;
import java.util.regex.Pattern;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String first, String second) { // "1. test
        String[] left = first.split(Pattern.quote(".")); // можно так
        String[] right = second.split("\\."); // а можно вот так
        return Integer.compare(Integer.parseInt(left[0]), Integer.parseInt(right[0]));
    }
}
