package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Pavel");
        names.add("Petr");
        names.add("Ivan");

        for (String s : names) {
            System.out.println(s);
        }
        System.out.println();
        names.set(0, "Luba");
        for (String s : names) {
            System.out.println(s);
        }

        System.out.println();
        names.remove(2);
        for (String s : names) {
            System.out.println(s);
        }
        System.out.println();

        for (int i = 0; i < names.size(); i++) {
            String s = names.get(i);
            System.out.println(s);
        }
    }
}
