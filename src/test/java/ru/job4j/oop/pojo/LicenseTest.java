package ru.job4j.oop.pojo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LicenseTest {
    @Test
    public void eqName() {
        License first = new License();
        first.setOwner("Aleks");
        first.setCode("xxx");
        first.setModel("audio");
        License second = new License();
        second.setOwner("Aleks");
        second.setCode("xxx");
        second.setModel("audio");
        assertThat(first, is(second));
    }
}