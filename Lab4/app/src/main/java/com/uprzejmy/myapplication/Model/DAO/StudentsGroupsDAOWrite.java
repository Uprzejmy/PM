package com.uprzejmy.myapplication.Model.DAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.uprzejmy.myapplication.Model.Database.StudentsGroupsSchema;
import com.uprzejmy.myapplication.Model.Entity.Group;
import com.uprzejmy.myapplication.Model.Entity.Student;

/**
 * Created by Uprzejmy on 26.11.2017.
 */

public class StudentsGroupsDAOWrite
{
    SQLiteDatabase database;

    public StudentsGroupsDAOWrite(SQLiteDatabase database)
    {
        this.database = database;
    }

    public void addStudentToGroup(Student student, Group group)
    {
        ContentValues values = new ContentValues();
        values.put(StudentsGroupsSchema.COLUMN_STUDENT_ID, student.getId());
        values.put(StudentsGroupsSchema.COLUMN_GROUP_ID, group.getId());

        database.insert(StudentsGroupsSchema.TABLE, null, values);
    }
}
