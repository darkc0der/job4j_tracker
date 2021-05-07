package ru.job4j.collection.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Pavel", "Ivanov", "9834531436", "Moscow"));
        ArrayList<Person> persons = phones.find("Iv");
        assertThat(persons.get(0).getSurname(), is("Ivanov"));
    }
}