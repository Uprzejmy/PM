package com.uprzejmy.myapplication.Model.Database;

/**
 * Created by Uprzejmy on 25.11.2017.
 */

public class GroupsTable
{
    //don't let anyone instantiate it by mistake
    private GroupsTable(){}

    public static final String TABLE = "groups";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT)";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE;
}
