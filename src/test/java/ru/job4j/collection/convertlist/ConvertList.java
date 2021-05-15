package ru.job4j.collection.convertlist;
/* 5. Конвертация листа массивов в один лист Integer [#393833] */
import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] i : list) {
            for (int j : i) {
                rsl.add(j);
            }
        }
        return rsl;
    }
}
