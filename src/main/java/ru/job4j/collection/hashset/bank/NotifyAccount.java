package ru.job4j.collection.hashset.bank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotifyAccount {
    public static Set<Account> sent(List<Account> accounts) {
        Set<Account> rsl = new HashSet<>();
        for (Account user : accounts) {
            rsl.add(user);
        }
        return rsl;
    }
}
