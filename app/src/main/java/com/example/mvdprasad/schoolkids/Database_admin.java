package com.example.mvdprasad.schoolkids;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database_admin extends SQLiteOpenHelper {
    ArrayList<Map<String, String>> data;
    public static final String DB_NAME = "student";
    public static final String TABLE_NAME = "table_name";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String COLUMN_ID = "column_id";
    public static final String PASSWORD = "password";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + NAME + " TEXT,"
                    + EMAIL + " TEXT,"
                    + PASSWORD + " TEXT"
                    + ")";

    public Database_admin(Context context) {
        super( context, DB_NAME, null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL( CREATE_TABLE );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertValues(String name_str, String username_str, String emailStr, String password_str, String email_str, String pass_str) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( EMAIL, email_str );
        values.put( PASSWORD, pass_str );

        sqLiteDatabase.insert( TABLE_NAME, null, values );
        // Toast.makeText(DataBaseClass.class, "successfully saved", Toast.LENGTH_SHORT).show();
    }

    public ArrayList <Map <String, String>> getRetrive(String username, String password) {
        data = new ArrayList();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery( "SELECT * FROM " + TABLE_NAME + " where " + EMAIL + " = '" + username + "' and " + PASSWORD + " = '" + password + "'", null );

        if (cursor.moveToFirst()) {

            do {
                Map <String, String> hmap = new HashMap<>();

                hmap.put( EMAIL, cursor.getString( cursor.getColumnIndex( EMAIL ) ) );
                hmap.put( PASSWORD, cursor.getString( cursor.getColumnIndex( PASSWORD ) ) );
                data.add( hmap );

            } while (cursor.moveToNext());
        }
        return data;
    }
}

