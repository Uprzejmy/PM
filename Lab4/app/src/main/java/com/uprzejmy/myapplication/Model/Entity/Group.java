package com.uprzejmy.myapplication.Model.Entity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Uprzejmy on 25.11.2017.
 */

public class Group
{
    private int id;
    private String name;
    private Collection<Student> students = new ArrayList<>();

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

    public Collection<Student> getStudents()
    {
        return students;
    }

    public void setStudents(Collection<Student> students)
    {
        this.students = students;
    }
}
