package com.uprzejmy.myapplication.Model.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.uprzejmy.myapplication.Model.Database.GroupsSchema;
import com.uprzejmy.myapplication.Model.Database.StudentsGroupsSchema;
import com.uprzejmy.myapplication.Model.Entity.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Uprzejmy on 26.11.2017.
 */

public class StudentsGroupsDAORead
{
    SQLiteDatabase database;

    public StudentsGroupsDAORead(SQLiteDatabase database)
    {
        this.database = database;
    }

    public List<Group> findGroupsByStudentId(int studentId)
    {
        List<Group> groups = new ArrayList<>();

        String parameter = Integer.toString(studentId);
        String query = "SELECT * FROM " + GroupsSchema.TABLE +
                " INNER JOIN " + StudentsGroupsSchema.TABLE +
                " ON " + GroupsSchema.TABLE + "." + GroupsSchema.COLUMN_ID + " = " + StudentsGroupsSchema.TABLE + "." + StudentsGroupsSchema.COLUMN_GROUP_ID +
                " WHERE " + StudentsGroupsSchema.COLUMN_STUDENT_ID + " = " + parameter;

        Cursor cursor = database.rawQuery(query, null);

        if(cursor != null)
        {
            cursor.moveToFirst();

            do
            {
                Group group = new Group();
                group.setId(cursor.getInt(cursor.getColumnIndex(GroupsSchema.COLUMN_ID)));
                group.setName(cursor.getString(cursor.getColumnIndex(GroupsSchema.COLUMN_NAME)));
                groups.add(group);
            } while(cursor.moveToNext());
        }

        return groups;
    }
}
