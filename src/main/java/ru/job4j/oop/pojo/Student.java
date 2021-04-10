package ru.job4j.oop.pojo;

import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private int group;
    private Date enrolled;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Date getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Date enrolled) {
        this.enrolled = enrolled;
    }
}
