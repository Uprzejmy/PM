package com.uprzejmy.myapplication.Model.Database;

import com.uprzejmy.myapplication.Model.Entity.Group;
import com.uprzejmy.myapplication.Model.Entity.Student;

import java.util.List;

/**
 * Created by Uprzejmy on 26.11.2017.
 */

public interface IDataManager
{
    boolean isEmptyDatabase();
    void addStudent(String name, String surname);
    void removeStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentWithGroups(Student student);
    void addGroup(String name);
    void removeGroup(Group group);
    List<Group> getAllGroups();
    Group getGroupWithStudents(Group group);
    void addStudentToGroup(Student student, Group group);
}
