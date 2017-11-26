package com.uprzejmy.myapplication.Model.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Uprzejmy on 25.11.2017.
 */

public class Group
{
    private int id;
    private String name;
    private List<Student> students = new ArrayList<>();

    public Group(){}

    public Group(String name)
    {
        this.name = name;
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

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    @Override
    public String toString()
    {
        //TODO remove id
        return
                "id: " + id + " " +
                " name: " + name + " ";
    }
}
