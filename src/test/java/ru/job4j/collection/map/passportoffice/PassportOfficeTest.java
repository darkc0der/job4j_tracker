package ru.job4j.collection.map.passportoffice;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("123", "Pavel");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addNotElement() {
        PassportOffice office = new PassportOffice();
        assertThat(office.get("Pavel"), nullValue());
    }
}