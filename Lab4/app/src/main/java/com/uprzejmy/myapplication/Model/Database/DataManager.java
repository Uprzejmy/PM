package com.uprzejmy.myapplication.Model.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.uprzejmy.myapplication.Model.DAO.StudentDAORead;
import com.uprzejmy.myapplication.Model.DAO.StudentDAOWrite;
import com.uprzejmy.myapplication.Model.Entity.Student;

import java.util.List;

/**
 * Created by Uprzejmy on 26.11.2017.
 */

public class DataManager
{
    private static Context context;
    private static DataManager instance;

    private DataManager(Context context)
    {
        this.context = context;
    }

    public static synchronized DataManager getDataManager(Context context)
    {
        if(instance == null)
        {
            instance = new DataManager(context);
        }

        return instance;
    }

    public boolean isTestDatabase()
    {
        if (getAllStudents().size() == 0)
        {
            return true;
        }

        return false;
    }
    public void addStudent(String name, String surname)
    {
        SQLiteDatabase database = DBHelper.getDBHelper(context).getWritableDatabase();

        StudentDAOWrite studentsDAO = new StudentDAOWrite(database);

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        studentsDAO.add(student);

        //TODO remove empty return?
        return;
    }

    public List<Student> getAllStudents()
    {
        SQLiteDatabase database = DBHelper.getDBHelper(context).getReadableDatabase();

        StudentDAORead studentsDAO = new StudentDAORead(database);

        return studentsDAO.findAll();
    }
}
