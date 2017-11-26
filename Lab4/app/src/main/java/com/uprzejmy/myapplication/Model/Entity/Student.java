package com.uprzejmy.myapplication.Model.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Uprzejmy on 25.11.2017.
 */

public class Student
{
    private int id;
    private String name;
    private String surname;
    private List<Group> groups = new ArrayList<>();

    public Student(){}

    public Student(String name, String surname)
    {
        this.name = name;
        this.surname = surname;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public List<Group> getGroups()
    {
        return groups;
    }

    public void setGroups(List<Group> groups)
    {
        this.groups = groups;
    }

    @Override
    public String toString()
    {
        //TODO remove id
        return
            "id: " + id + " " +
            "name: " + name + " " +
            "surname: " + surname;
    }
}
