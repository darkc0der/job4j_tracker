package ru.job4j.collection.hashset.bank;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("25", "Pavel", "200"),
                new Account("24", "Ivan", "50"),
                new Account("25", "John", "2000")
        );
        Set<Account> expected = new HashSet<>(
                Arrays.asList(
                        new Account("25", "Pavel", "200"),
                        new Account("24", "Ivan", "50")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expected));
    }
}