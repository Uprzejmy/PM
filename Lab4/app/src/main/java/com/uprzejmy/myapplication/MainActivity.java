package com.uprzejmy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.uprzejmy.myapplication.Model.Database.DataManager;
import com.uprzejmy.myapplication.Model.Entity.Student;

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadExampleData();
    }

    public void StudentsListActivity(View view)
    {
        Intent intent = new Intent(this, StudentsList.class);
        startActivity(intent);
    }

    private void loadExampleData()
    {
        DataManager dataManager = DataManager.getDataManager(this);

        if(!dataManager.isTestDatabase())
        {
            return;
        }

        for (Student student : students)
        {
            dataManager.addStudent(student.getName(), student.getSurname());
        }
    }
}
