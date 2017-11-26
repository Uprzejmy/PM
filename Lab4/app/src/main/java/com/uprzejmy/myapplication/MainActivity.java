package com.uprzejmy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.uprzejmy.myapplication.Model.Database.DataManager;
import com.uprzejmy.myapplication.Model.Database.IDataManager;
import com.uprzejmy.myapplication.Model.Entity.Group;
import com.uprzejmy.myapplication.Model.Entity.Student;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private static Student[] students =
            {
                    new Student("Jerzy", "Kiler"),
                    new Student("Ewa", "Szańska"),
                    new Student("Jerzy", "Ryba"),
                    new Student("Ryszarda", "Siarzewska"),
                    new Student("Stefan", "Siarzewski"),
                    new Student("Ferdynand", "Lipski"),
                    new Student("Mieczysław", "Klonisz")
            };

    private static Group[] groups =
            {
                    new Group("pierwsza grupa"),
                    new Group("druga grupa"),
                    new Group("trzecia grupa"),
                    new Group("czwarta grupa")
            };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadExampleData();
    }

    public void StudentsListActivity(View view)
    {
        Intent intent = new Intent(this, StudentsListActivity.class);
        startActivity(intent);
    }

    public void GroupsListActivity(View view)
    {
        Intent intent = new Intent(this, GroupsListActivity.class);
        startActivity(intent);
    }

    private void loadExampleData()
    {
        IDataManager dataManager = DataManager.getDataManager(this);

        if(!dataManager.isEmptyDatabase())
        {
            return;
        }

        Random generator = new Random();

        for (Student student : students)
        {
            dataManager.addStudent(student.getName(), student.getSurname());
        }

        for (Group group : groups)
        {
            dataManager.addGroup(group.getName());
        }

        List<Group> groups = dataManager.getAllGroups();
        List<Student> students = dataManager.getAllStudents();

        for (Group group : groups)
        {
            for (Student student : students)
            {
                if(generator.nextDouble() < 0.4)
                {
                    dataManager.addStudentToGroup(student, group);
                }
            }
        }
    }
}
