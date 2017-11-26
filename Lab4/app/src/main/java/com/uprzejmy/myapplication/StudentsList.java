package com.uprzejmy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.uprzejmy.myapplication.Model.Database.DataManager;

public class StudentsList extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);

        DataManager dataManager = DataManager.getDataManager(this);

        ListView studentsListView = findViewById(R.id.studentsListView);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataManager.getAllStudents());
        studentsListView.setAdapter(adapter);
    }
}
