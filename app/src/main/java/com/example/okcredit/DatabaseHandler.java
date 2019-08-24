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


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_ACTIVITY_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + Given_Money + " INTEGER ," + Given_Discription + " TEXT,"
                + Given_Time + " TEXT," + Money_Status + " INTEGER," + User_Name + " TEXT," + Mobile_Number + " TEXT " + ")";
        sqLiteDatabase.execSQL(CREATE_ACTIVITY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
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
}