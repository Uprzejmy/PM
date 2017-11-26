package com.uprzejmy.myapplication.Model.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.uprzejmy.myapplication.Model.DAO.*;
import com.uprzejmy.myapplication.Model.Entity.Group;
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

    public boolean isEmptyDatabase()
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

    public void removeStudent(Student student)
    {
        SQLiteDatabase database = DBHelper.getDBHelper(context).getWritableDatabase();

        StudentDAOWrite studentsDAO = new StudentDAOWrite(database);

        studentsDAO.remove(student);
    }

    public List<Student> getAllStudents()
    {
        SQLiteDatabase database = DBHelper.getDBHelper(context).getReadableDatabase();

        StudentDAORead studentsDAO = new StudentDAORead(database);

        return studentsDAO.findAll();
    }

    public Student getStudentWithGroups(Student student)
    {
        SQLiteDatabase database = DBHelper.getDBHelper(context).getReadableDatabase();

        StudentsGroupsDAORead studentsGroupsDAO = new StudentsGroupsDAORead(database);

        student.setGroups(studentsGroupsDAO.findGroupsByStudentId(student.getId()));

        return student;
    }

    public void addGroup(String name)
    {
        SQLiteDatabase database = DBHelper.getDBHelper(context).getWritableDatabase();

        GroupDAOWrite groupDAO = new GroupDAOWrite(database);

        Group group = new Group();
        group.setName(name);
        groupDAO.add(group);

        //TODO remove empty return?
        return;
    }

    public List<Group> getAllGroups()
    {
        SQLiteDatabase database = DBHelper.getDBHelper(context).getReadableDatabase();

        GroupDAORead groupDAO = new GroupDAORead(database);

        return groupDAO.findAll();
    }

    public void addStudentToGroup(Student student, Group group)
    {
        SQLiteDatabase database = DBHelper.getDBHelper(context).getWritableDatabase();

        StudentsGroupsDAOWrite studentsGroupsDAO = new StudentsGroupsDAOWrite(database);

        studentsGroupsDAO.addStudentToGroup(student, group);
    }
}
