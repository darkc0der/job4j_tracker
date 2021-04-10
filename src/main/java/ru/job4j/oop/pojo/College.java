package ru.job4j.oop.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Pavel");
        student.setLastName("Ivanov");
        student.setGroup(120);
        student.setEnrolled(new Date());
        System.out.println(student.getFirstName() + " " + student.getLastName()
            + " of group " + student.getGroup() + " enrolled in college " + student.getEnrolled());
    }
}
