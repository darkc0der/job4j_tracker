package ru.job4j.collection.map.listtomap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderConvert {
    public static Map<String, Order> process(List<Order> orders) {
        Map<String, Order> rsl = new HashMap<>();
        for (Order order : orders) {
            String key = order.getNumber();
            rsl.put(key, order);
        }
        return rsl;
    }
}
