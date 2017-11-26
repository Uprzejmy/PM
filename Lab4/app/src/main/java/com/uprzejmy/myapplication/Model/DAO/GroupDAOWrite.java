package com.uprzejmy.myapplication.Model.DAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.uprzejmy.myapplication.Model.Database.GroupsSchema;
import com.uprzejmy.myapplication.Model.Entity.Group;

/**
 * Created by Uprzejmy on 26.11.2017.
 */

public class GroupDAOWrite implements IDAOWrite<Group>
{
    SQLiteDatabase database;

    public GroupDAOWrite(SQLiteDatabase database)
    {
        this.database = database;
    }

    @Override
    public void add(Group group)
    {
        ContentValues values = new ContentValues();
        values.put(GroupsSchema.COLUMN_NAME, group.getName());

        database.insert(GroupsSchema.TABLE, null, values);
    }

    @Override
    public void update(Group group)
    {

    }

    @Override
    public void remove(Group group)
    {
        database.delete(GroupsSchema.TABLE, GroupsSchema.COLUMN_ID + " = ?", new String[]{Integer.toString(group.getId())});
    }
}
