package com.uprzejmy.myapplication.Model.Database;

/**
 * Created by Uprzejmy on 25.11.2017.
 */

public class StudentsGroupsTable
{
    //don't let anyone instantiate it by mistake
    private StudentsGroupsTable(){}

    public static final String TABLE = "students_groups";
    public static final String COLUMN_STUDENT_ID = "student_id";
    public static final String COLUMN_GROUP_ID = "group_id";

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " (" +
            COLUMN_STUDENT_ID + " INTEGER NOT NULL, " +
            COLUMN_GROUP_ID + " INTEGER NOT NULL, " +
            "CONSTRAINT students_groups_primary_key PRIMARY KEY (" + COLUMN_STUDENT_ID + ", " + COLUMN_GROUP_ID + ") " +
            "CONSTRAINT students_groups_student_fk FOREIGN KEY (" + COLUMN_STUDENT_ID + ") " +
            "REFERENCES " + StudentsTable.TABLE + "(" + StudentsTable.COLUMN_ID + "), " +
            "CONSTRAINT students_groups_groups_fk FOREIGN KEY (" + COLUMN_GROUP_ID + ") " +
            "REFERENCES " + GroupsTable.TABLE + "(" + GroupsTable.COLUMN_ID + "))";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE;
}
