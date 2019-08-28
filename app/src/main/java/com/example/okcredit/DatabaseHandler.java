package com.example.okcredit;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "registration";
    public static final String TABLE_NAME = "okcredit";

    public static final String Given_Money = "given_money";
    public static final String Given_Discription = "given_discription";
    public static final String Given_Time = "given_time";
    public static final String Money_Status = "money_status";
    public static final String User_Name = "user_name";
    public static final String Mobile_Number = "mobile_number";
    public static final String Give_Curren_Time = "give_current_time";

    public static final String ALL_USER_TABLE = "allusertable";
    public static final String Totel_Money = "totel_money";
    public static final String Status = "status";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_ACTIVITY_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + Given_Money + " INTEGER ," + Given_Discription + " TEXT,"
                + Money_Status + " INTEGER," + User_Name + " TEXT," + Mobile_Number + " TEXT ," + Given_Time + " INTEGER , " + Give_Curren_Time + " INTEGER " + ")";
        sqLiteDatabase.execSQL(CREATE_ACTIVITY_TABLE);


        String CREATE_ALL_USER_ACTIVITY = "CREATE TABLE " + ALL_USER_TABLE + "(" + User_Name + " TEXT,"
                + Status + " TEXT," + Totel_Money + " INTEGER," + Mobile_Number + " TEXT " + ")";
        sqLiteDatabase.execSQL(CREATE_ALL_USER_ACTIVITY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + ALL_USER_TABLE);
        onCreate(sqLiteDatabase);

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("Select * From " + TABLE_NAME, null);
        return result;
    }

    public Cursor getPaymentInfoByNumber(String mobileNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mobile = db.rawQuery("Select * From " + TABLE_NAME + " WHERE " + DatabaseHandler.Mobile_Number + " = '" + mobileNumber + "'", null);
        return mobile;
    }

    public Cursor getAllUserData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("Select * From " + ALL_USER_TABLE, null);
        return result;
    }
}