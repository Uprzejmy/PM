package com.uprzejmy.myapplication.Model.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.uprzejmy.myapplication.Model.Database.StudentsSchema;
import com.uprzejmy.myapplication.Model.Entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Uprzejmy on 25.11.2017.
 */

public class StudentDAORead implements IDAORead<Student>
{
    SQLiteDatabase database;

    public StudentDAORead(SQLiteDatabase database)
    {
        this.database = database;
    }

    @Override
    public Student findById(int id)
    {
        String[] parameters = {Integer.toString(id)};
        Cursor cursor = database.query(StudentsSchema.TABLE, StudentsSchema.COLUMNS, "WHERE id = ?", parameters, null, null, null, null);

        if(cursor != null)
        {
            cursor.moveToFirst();
        }

        Student student = new Student();
        student.setId(cursor.getInt(cursor.getColumnIndex(StudentsSchema.COLUMN_ID)));
        student.setName(cursor.getString(cursor.getColumnIndex(StudentsSchema.COLUMN_NAME)));
        student.setSurname(cursor.getString(cursor.getColumnIndex(StudentsSchema.COLUMN_SURNAME)));

        return student;
    }

    @Override
    public List<Student> findAll()
    {
        List<Student> students = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM " + StudentsSchema.TABLE,null);
        //query(StudentsSchema.TABLE, null, null, null, null, null, null);

        if(cursor != null)
        {
            cursor.moveToFirst();

            do
            {
                Student student = new Student();
                student.setId(cursor.getInt(cursor.getColumnIndex(StudentsSchema.COLUMN_ID)));
                student.setName(cursor.getString(cursor.getColumnIndex(StudentsSchema.COLUMN_NAME)));
                student.setSurname(cursor.getString(cursor.getColumnIndex(StudentsSchema.COLUMN_SURNAME)));
                students.add(student);
            } while(cursor.moveToNext());
        }

        return students;
    }
}
