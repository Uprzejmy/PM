package com.uprzejmy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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

    public void editStudent(View view, s)
    {
        setContentView(R.layout.activity_students_edit);

        TextView nameField = findViewById(R.id.studentName);
        TextView surnameField = findViewById(R.id.studentSurname);
    }

    public void editStudentConfirm(View view)
    {

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
        setContentView(R.layout.activity_students_groups_list);

        DataManager dataManager = DataManager.getDataManager(this);

        Student student = dataManager.getStudentWithGroups(students.get(position));

        studentsGroupsListView = findViewById(R.id.studentsGroupsListView);

        studentsGroupsListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, student.getGroups());
        studentsGroupsListView.setAdapter(studentsGroupsListAdapter);

        Button switchButton = findViewById(R.id.editStudentButton);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editStudent(view);
            }
        });
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
