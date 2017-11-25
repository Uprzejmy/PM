package com.uprzejmy.myapplication.Model.Entity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Uprzejmy on 25.11.2017.
 */

public class Student
{
    private int id;
    private String name;
    private String surname;
    private Collection<Group> groups = new ArrayList<>();

    public int getId()
    {
        return id;
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

    public Collection<Group> getGroups()
    {
        return groups;
    }

    public void setGroups(Collection<Group> groups)
    {
        this.groups = groups;
    }
}
