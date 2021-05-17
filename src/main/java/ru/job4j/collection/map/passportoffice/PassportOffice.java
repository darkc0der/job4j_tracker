package ru.job4j.collection.map.passportoffice;
/* 1. Паспорт и жители [#393838] */
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = citizens.containsKey(citizen.getPassport());
        if (!rsl) {
            citizens.put(citizen.getPassport(), citizen);
        }
        return rsl;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}
