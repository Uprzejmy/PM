package com.uprzejmy.myapplication.Model.Database;

/**
 * Created by Uprzejmy on 25.11.2017.
 */

public class StudentsSchema
{
    //don't let anyone instantiate it by mistake
    private StudentsSchema(){}

    public static final String TABLE = "students";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";

    public static final String[] COLUMNS = {COLUMN_ID, COLUMN_NAME, COLUMN_SURNAME};

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_SURNAME + " TEXT)";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE;
}
