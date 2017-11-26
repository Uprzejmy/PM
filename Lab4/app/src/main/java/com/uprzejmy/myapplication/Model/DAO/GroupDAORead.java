package com.uprzejmy.myapplication.Model.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.uprzejmy.myapplication.Model.Database.GroupsSchema;
import com.uprzejmy.myapplication.Model.Database.StudentsSchema;
import com.uprzejmy.myapplication.Model.Entity.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Uprzejmy on 26.11.2017.
 */

public class GroupDAORead implements IDAORead<Group>
{
    SQLiteDatabase database;

    public GroupDAORead(SQLiteDatabase database)
    {
        this.database = database;
    }

    @Override
    public Group findById(int id)
    {
        String[] parameters = {Integer.toString(id)};
        Cursor cursor = database.query(GroupsSchema.TABLE, GroupsSchema.COLUMNS, "WHERE id = ?", parameters, null, null, null, null);

        Group group = new Group();

        if(cursor != null)
        {
            cursor.moveToFirst();

            group.setId(cursor.getInt(cursor.getColumnIndex(GroupsSchema.COLUMN_ID)));
            group.setName(cursor.getString(cursor.getColumnIndex(GroupsSchema.COLUMN_NAME)));

            cursor.close();
        }


        return group;
    }

    @Override
    public List<Group> findAll()
    {
        List<Group> groups = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM " + GroupsSchema.TABLE, null);

        if(cursor != null)
        {
            cursor.moveToFirst();

            do
            {
                Group group = new Group();
                group.setId(cursor.getInt(cursor.getColumnIndex(StudentsSchema.COLUMN_ID)));
                group.setName(cursor.getString(cursor.getColumnIndex(StudentsSchema.COLUMN_NAME)));
                groups.add(group);
            } while(cursor.moveToNext());

            cursor.close();
        }

        return groups;
    }
}
