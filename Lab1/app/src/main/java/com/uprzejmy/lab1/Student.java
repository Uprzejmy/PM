package com.uprzejmy.lab1;

/**
 * Created by Wikusia on 22.10.2017.
 */

public class Student {
    private String name;
    private String surname;


    public Student(String name, String surname)
    {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString()
    {
        return surname + " " + name;
    }
}
