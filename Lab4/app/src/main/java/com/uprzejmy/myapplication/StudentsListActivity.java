package com.uprzejmy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.uprzejmy.myapplication.Model.Database.DataManager;
import com.uprzejmy.myapplication.Model.Entity.Student;

import java.util.List;

public class StudentsListActivity extends AppCompatActivity
{
    List<Student> students;
    ArrayAdapter studentsListAdapter;
    ArrayAdapter studentsGroupsListAdapter;
    ListView studentsListView;
    ListView studentsGroupsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);

        DataManager dataManager = DataManager.getDataManager(this);

        students = dataManager.getAllStudents();
        studentsListView = findViewById(R.id.studentsListView);

        studentsListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
        studentsListView.setAdapter(studentsListAdapter);

        configureListeners();
    }

    private void deleteStudent(int position)
    {
        DataManager dataManager = DataManager.getDataManager(this);

        dataManager.removeStudent(students.get(position));
        students.remove(position);

        studentsListAdapter.notifyDataSetChanged();
    }

    private void showStudentsGroups(int position)
    {
        DataManager dataManager = DataManager.getDataManager(this);

        Student student = dataManager.getStudentWithGroups(students.get(position));

        studentsGroupsListView = findViewById(R.id.studentsListView);

        studentsGroupsListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, student.getGroups());
        studentsGroupsListView.setAdapter(studentsGroupsListAdapter);
    }

    private void configureListeners()
    {
        studentsListView.setOnItemLongClickListener(
                (arg0, arg1, position, arg3) ->
                {
                    deleteStudent(position);

                    return true;
                });

        studentsListView.setOnItemClickListener(
                (arg0, arg1, position, arg3) ->
                {
                    showStudentsGroups(position);
                });
    }
}
