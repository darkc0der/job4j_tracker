package ru.job4j.collection.map.hashmap;
/* 0. Map, HashMap [#393837] */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("pavelall@yandex.ru", "Pavel");
        map.put("ivanall@mail.ru", "Ivan");
        map.put("sergey2000@gmail.com", "Sergey");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " : " + map.get(key));
        }

        /* Возвращает Set в котором содержится MapEntry<String, String> */
        Set<Map.Entry<String, String>> set = map.entrySet();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }

        System.out.println("\n");

        map.put("pavelall@yandex.ru", "Nadya");
        map.put("ivanall@mail.ru", "Ira");
        map.put("luba@mail.ru", "Luba");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }

        System.out.println("\n");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }

        map.remove("sergey2000@gmail.com");
        System.out.println("\n");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
