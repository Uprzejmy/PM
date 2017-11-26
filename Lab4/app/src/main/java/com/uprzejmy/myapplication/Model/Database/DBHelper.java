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
    private static DBHelper instance;

    private DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DBHelper getDBHelper(Context context)
    {
        if(instance == null)
        {
            instance = new DBHelper(context.getApplicationContext());
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(StudentsSchema.CREATE_TABLE);
        database.execSQL(GroupsSchema.CREATE_TABLE);
        database.execSQL(StudentsGroupsSchema.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
    {
        database.execSQL(StudentsGroupsSchema.DROP_TABLE);
        database.execSQL(StudentsSchema.DROP_TABLE);
        database.execSQL(GroupsSchema.DROP_TABLE);

        onCreate(database);
    }
}
