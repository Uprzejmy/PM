package com.uprzejmy.myapplication.Model.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Uprzejmy on 25.11.2017.
 */

public class DBHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "lab4-db";

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(StudentsTable.CREATE_TABLE);
        database.execSQL(GroupsTable.CREATE_TABLE);
        database.execSQL(StudentsGroupsTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
    {
        database.execSQL(StudentsGroupsTable.DROP_TABLE);
        database.execSQL(StudentsTable.DROP_TABLE);
        database.execSQL(GroupsTable.DROP_TABLE);

        onCreate(database);
    }
}
