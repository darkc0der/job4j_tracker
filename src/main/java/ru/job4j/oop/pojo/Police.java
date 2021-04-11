package ru.job4j.oop.pojo;

import java.util.Date;

public class Police {
    public static void main(String[] args) {
        License license = new License();
        license.setOwner("Pavel Ivanov");
        license.setModel("Honda");
        license.setCode("xx11xx");
        license.setCreated(new Date());

        System.out.println(license.getOwner() + " has a car - "
                + license.getModel() + " : " + license.getCode());

        License licenseTwo = new License();
        licenseTwo.setOwner("Pavel Ivanov");
        licenseTwo.setModel("Honda");
        licenseTwo.setCode("xx11xx");
        licenseTwo.setCreated(new Date());

        boolean eq = license.equals(licenseTwo);
        System.out.println(eq);
    }
}
