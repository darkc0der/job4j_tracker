package ru.job4j.collection.hashset.uniquetext;

import java.util.HashSet;
import java.util.Set;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        Set<String> check = new HashSet<>();

        for (String t : origin) {
               check.add(t);
        }

        for (String t : text) {
            if (!check.contains(t)) {
                return false;
            }
        }
        return rsl;
    }
}
