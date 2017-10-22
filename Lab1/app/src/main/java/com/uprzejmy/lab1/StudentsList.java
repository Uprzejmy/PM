package com.uprzejmy.lab1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StudentsList extends Activity {

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
        setContentView(R.layout.activity_students_list);

        ListView studentsListView = findViewById(R.id.studentsListView);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
        studentsListView.setAdapter(adapter);
    }
}
