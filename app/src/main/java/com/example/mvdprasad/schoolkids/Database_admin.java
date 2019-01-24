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
    ArrayList<Map<String, String>> data,student_data;
    public static final String DB_NAME = "student";
    public static final String TABLE_NAME = "table_name";
    public static final String NAME = "name";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public static final String COLUMN_ID = "column_id";
    public static final String PASSWORD = "password";
    public static final String ADDRESS = "address";
    public static final String PHONE = "phone";
    public static final String GENDER = "gender";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + NAME + " TEXT,"
                    + USERNAME + " TEXT,"
                    + EMAIL + " TEXT,"
                    + PASSWORD + " TEXT,"
                    + ADDRESS + " TEXT,"
                    + PHONE + " TEXT,"
                    + GENDER + " TEXT"
                    + ")";

    public static final String TABLE_NAME1 = "table_name1";
    public static final String BUSROUTENO = "Bus_Route_No";
    public static final String ROUTENAME = "Route_Name";
    public static final String ROUTEFROM = "Route_From";
    public static final String ROUTETO = "Route_To";
    public static final String LANDMARK = "Landmark";
    public static final String LATTITUDE = "lattitude";
    public static final String LONGITUDE = "longitude";
    public static final String MESSAGE = "Message";

    public static final String COLUMN_ID1 = "column_id1";
    public static final String CREATE_TABLE1 =
            "CREATE TABLE " + TABLE_NAME1 + "("
                    + COLUMN_ID1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + BUSROUTENO + " TEXT,"
                    + ROUTENAME + " TEXT,"
                    + ROUTEFROM + " TEXT,"
                    + ROUTETO + " TEXT,"
                    + LANDMARK + " TEXT,"
                    + LATTITUDE + " TEXT,"
                    + LONGITUDE + " TEXT,"
                    + MESSAGE + " TEXT"
                    + ")";

    public static final String TABLE_NAME2 ="table_name2";
    public static final String ROLL_NO = "rollno";
    public static final String NAME1 = "name";
    public static final String DOB = "dob";
    public static final String FATHER_NAME = "fathername";
    public static final String BUS_NO = "busno";
    public static final String ADDRESS1 = "address";
    public static final String SECTION_OF_CLASS = "sectionofclass";
    public static final String GENDER1= "gender";
    public static final String MOTHERNAME = "mothername";
    public static final String CELL_NO = "cellno";
    public static final String PASSWORD1 = "password";
    public static final String COLUMN_ID2 = "column_id2";
    public static final String CREATE_TABLE2 =
            "CREATE TABLE " + TABLE_NAME2 + "("
                    + COLUMN_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + ROLL_NO + " TEXT,"
                    + NAME1 + " TEXT,"
                    + DOB + " TEXT,"
                    + FATHER_NAME + " TEXT,"
                    + BUS_NO + " TEXT,"
                    + ADDRESS1 + " TEXT,"
                    + SECTION_OF_CLASS + " TEXT,"
                    + GENDER1 + " TEXT,"
                    + MOTHERNAME + " TEXT,"
                    + CELL_NO + " TEXT,"
                    + PASSWORD1 + " TEXT"
                    + ")";

    public Database_admin(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE1);
        db.execSQL(CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertValues(String name_str, String username_str, String email_Str, String password_str, String address, String phone_str,String gender) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name_str);
        values.put(USERNAME, username_str);
        values.put(EMAIL, email_Str);
        values.put(PASSWORD, password_str);
        values.put(ADDRESS, address);
        values.put(PHONE, phone_str);
        values.put(GENDER, gender);
        sqLiteDatabase.insert(TABLE_NAME, null, values);
        // Toast.makeText(DataBaseClass.class, "successfully saved", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Map<String, String>> getRetrive(String username, String password) {
        data = new ArrayList();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " where " + EMAIL + " = '" + username + "' and " + PASSWORD + " = '" + password + "'", null);

        if (cursor.moveToFirst()) {

            do {
                Map<String, String> hmap = new HashMap<>();

                hmap.put(EMAIL, cursor.getString(cursor.getColumnIndex(EMAIL)));
                hmap.put(PASSWORD, cursor.getString(cursor.getColumnIndex(PASSWORD)));
                data.add(hmap);

            } while (cursor.moveToNext());
        }
        return data;
    }
    public ArrayList<Map<String, String>> getRetriveAll(String email) {
        data = new ArrayList();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME+ " where " + EMAIL + " = '" + email + "'", null);

        if (cursor.moveToFirst()) {

            do {
                Map<String, String> hmap = new HashMap<>();
                hmap.put(NAME, cursor.getString(cursor.getColumnIndex(NAME)));
                hmap.put(USERNAME, cursor.getString(cursor.getColumnIndex(USERNAME)));
                hmap.put(EMAIL, cursor.getString(cursor.getColumnIndex(EMAIL)));
                hmap.put(PASSWORD, cursor.getString(cursor.getColumnIndex(PASSWORD)));
                hmap.put(ADDRESS, cursor.getString(cursor.getColumnIndex(ADDRESS)));
                hmap.put(PHONE, cursor.getString(cursor.getColumnIndex(PHONE)));
                hmap.put(GENDER, cursor.getString(cursor.getColumnIndex(GENDER)));
                data.add(hmap);

            } while (cursor.moveToNext());
        }
        return data;
    }

    public boolean updateData(String name,String username,String email,String password,String gender,String phone,String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME,name);
        contentValues.put(USERNAME,username);
        contentValues.put(EMAIL,email);
        contentValues.put(PASSWORD,password);
        contentValues.put(ADDRESS,address);
        contentValues.put(PHONE,phone);
        contentValues.put(GENDER,gender);
        db.update(TABLE_NAME, contentValues, "NAME = ?",new String[] { name });
        return true;
    }
    public void insertRoute(String BUSROUTENO_str, String ROUTENAME_str, String ROUTEFROM_str, String ROUTETO_str) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BUSROUTENO, BUSROUTENO_str);
        values.put(ROUTENAME, ROUTENAME_str);
        values.put(ROUTEFROM, ROUTEFROM_str);
        values.put(ROUTETO, ROUTETO_str);

        sqLiteDatabase.insert(TABLE_NAME1, null, values);
        // Toast.makeText(DataBaseClass.class, "successfully saved", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<Map<String, String>> getRoute() {
        data = new ArrayList();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME1  , null);

        if (cursor.moveToFirst()) {

            do {
                Map<String, String> hmap = new HashMap<>();
                hmap.put(BUSROUTENO, cursor.getString(cursor.getColumnIndex(BUSROUTENO)));
                hmap.put(ROUTENAME, cursor.getString(cursor.getColumnIndex(ROUTENAME)));
                hmap.put(ROUTEFROM, cursor.getString(cursor.getColumnIndex(ROUTEFROM)));
                hmap.put(ROUTETO, cursor.getString(cursor.getColumnIndex(ROUTETO)));
                data.add(hmap);

            } while (cursor.moveToNext());
        }
        return data;
    }
    public boolean updateRoute(String Route_no_str,String Route_NAME_str,String Route_From_str,String Route_To_str) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(BUSROUTENO,Route_no_str);
        contentValues.put(ROUTENAME,Route_NAME_str);
        contentValues.put(ROUTEFROM,Route_From_str);
        contentValues.put(ROUTETO,Route_To_str);
        db.update(TABLE_NAME1, contentValues, "Bus_Route_No = ?",new String[] { Route_no_str });
        return true;
    }
    public Integer deleteData (String Route_no_str) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME1, "Bus_Route_No = ?",new String[] {Route_no_str});
    }

    public boolean insertLandmark(String Landmark1_str,String Latitude_str,String Longitude_str,String Message_str,String route_No) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(LANDMARK,Landmark1_str);
        contentValues.put(LATTITUDE,Latitude_str);
        contentValues.put(LONGITUDE,Longitude_str);
        contentValues.put(MESSAGE,Message_str);
        db.update(TABLE_NAME1, contentValues, "Bus_Route_No = ?",new String[] { route_No });
        return true;
    }

    public void insert_studentdetails(String Rollno_str, String Birthday_str, String Name_str, String Cell_no_str, String Bus_no_str,String Adress_str,String Section_of_class_str,String Father_name_str,String Mother_name_str,String Passwrd_str,String Gender_str) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( ROLL_NO, Rollno_str );
        values.put( NAME1, Name_str );
        values.put( DOB, Birthday_str );
        values.put( FATHER_NAME, Father_name_str );
        values.put( BUS_NO, Bus_no_str );
        values.put( ADDRESS1, Adress_str );
        values.put( SECTION_OF_CLASS, Section_of_class_str );
        values.put( MOTHERNAME, Mother_name_str );
        values.put( GENDER1, Gender_str );
        values.put( CELL_NO, Cell_no_str );
        values.put( PASSWORD1, Passwrd_str );

        sqLiteDatabase.insert( TABLE_NAME2, null, values );

    }

    public ArrayList <Map <String, String>> getstudentdata() {

        student_data = new ArrayList();

        SQLiteDatabase sqLiteDatabase2 = getReadableDatabase();

        Cursor cursor= sqLiteDatabase2.rawQuery( "SELECT * FROM " + TABLE_NAME2  , null );

        if (cursor.moveToFirst()) {

            do {
                Map <String, String> hmap = new HashMap <>();

                hmap.put( ROLL_NO, cursor.getString( cursor.getColumnIndex( ROLL_NO ) ) );
                hmap.put( NAME1, cursor.getString( cursor.getColumnIndex( NAME1 ) ) );
                hmap.put( DOB, cursor.getString( cursor.getColumnIndex( DOB ) ) );
                hmap.put( FATHER_NAME, cursor.getString( cursor.getColumnIndex( FATHER_NAME ) ) );
                hmap.put( BUS_NO, cursor.getString( cursor.getColumnIndex( BUS_NO ) ) );
                hmap.put( ADDRESS, cursor.getString( cursor.getColumnIndex( ADDRESS ) ) );
                hmap.put( SECTION_OF_CLASS, cursor.getString( cursor.getColumnIndex( SECTION_OF_CLASS ) ) );
                hmap.put( MOTHERNAME, cursor.getString( cursor.getColumnIndex( MOTHERNAME ) ) );
                hmap.put( GENDER, cursor.getString( cursor.getColumnIndex( GENDER ) ) );
                hmap.put( CELL_NO, cursor.getString( cursor.getColumnIndex( CELL_NO ) ) );
                hmap.put( PASSWORD1, cursor.getString( cursor.getColumnIndex( PASSWORD1 ) ) );

                student_data.add( hmap );

            } while (cursor.moveToNext());
        }
        return student_data;
    }
    public boolean updateStudent(String ROLL_NO_str,String NAME1_str,String DOB_str,String FATHER_NAME_str,String BUS_NO_str,String ADDRESS_str,String SECTION_OF_CLASS_str,String MOTHERNAME_str,String GENDER_str,String CELL_NO_str) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ROLL_NO,ROLL_NO_str);
        contentValues.put(NAME1,NAME1_str);
        contentValues.put(DOB,DOB_str);
        contentValues.put(FATHER_NAME,FATHER_NAME_str);
        contentValues.put(BUS_NO,BUS_NO_str);
        contentValues.put(ADDRESS,ADDRESS_str);
        contentValues.put(SECTION_OF_CLASS,SECTION_OF_CLASS_str);
        contentValues.put(MOTHERNAME,MOTHERNAME_str);
        contentValues.put(GENDER,GENDER_str);
        contentValues.put(CELL_NO,CELL_NO_str);
        db.update(TABLE_NAME2, contentValues, "rollno = ?",new String[] { ROLL_NO_str });
        return true;
    }
    public Integer deleteStudent (String Route_no_str) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME2, "rollno = ?",new String[] {Route_no_str});
    }
}

