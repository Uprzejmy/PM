package com.uprzejmy.myapplication.Model.DAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.uprzejmy.myapplication.Model.Database.StudentsSchema;
import com.uprzejmy.myapplication.Model.Entity.Student;

/**
 * Created by Uprzejmy on 26.11.2017.
 */

public class StudentDAOWrite implements IDAOWrite<Student>
{
    SQLiteDatabase database;

    public StudentDAOWrite(SQLiteDatabase database)
    {
        this.database = database;
    }

    public void add(Student student)
    {
        ContentValues values = new ContentValues();
        values.put(StudentsSchema.COLUMN_NAME, student.getName());
        values.put(StudentsSchema.COLUMN_SURNAME, student.getSurname());

        database.insert(StudentsSchema.TABLE, null, values);
    }

    @Override
    public void update(Student item)
    {

    }

    @Override
    public void remove(Student item)
    {

    }
}
