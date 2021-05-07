package ru.job4j.collection.convertmatrixtolist;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> rsl = new ArrayList<Integer>();
        for (int[] row : array) {
            for (int cell : row) {
                rsl.add(cell);
            }
        }
        return rsl;
    }
}
