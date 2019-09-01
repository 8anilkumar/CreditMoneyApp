package com.example.okcredit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent= new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },4000);
    }


//
//    String srtcount = "";
//    String current_balenc = "";
//    String user_no = "";
//    cursor = openHelper.getAllUserData();
//        if (cursor.moveToFirst()) {
//        do {
//
//            user_no = cursor.getString(1);
//
//            SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("TOTEL_USER", String.valueOf(user_no));
//            editor.commit();
//
//        }
//        while (cursor.moveToNext());
//
//    }
//
//        if (mobileNumber == user_no) {
//
//        updateDate(totel, mobileNumber);
//
//    } else {
//
//        if (user_totel_amount > customer_totel_amount) {
//            payment = String.valueOf(user_totel_amount - customer_totel_amount);
//            totel = payment + " Due";
//            Calendar calendar = Calendar.getInstance();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
//            current_time = simpleDateFormat.format(calendar.getTime());
//            insertTotel(username, mobileNumber, current_time, totel);
//
//
//        } else {
//            advance = String.valueOf(customer_totel_amount - user_totel_amount);
//            totel = advance + " Advance";
//
//            Calendar calendar = Calendar.getInstance();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
//            current_time = simpleDateFormat.format(calendar.getTime());
//            insertTotelData(username, mobileNumber, current_time, totel);
//        }
//    }
//    CastumerAdapter adapter = new CastumerAdapter(modelClasses);
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//        call.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Intent intcall = new Intent(Intent.ACTION_CALL);
//            if (mobileNumber.trim().isEmpty()) {
//                intcall.setData(Uri.parse("tel:5677889"));
//            } else {
//                intcall.setData(Uri.parse("tel:" + mobileNumber));
//            }
//            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(Friendlistpagecontact.this, "Please grant Permission", Toast.LENGTH_SHORT).show();
//                requestPermission();
//            } else {
//                startActivity(intcall);
//            }
//        }
//
//        private void requestPermission() {
//            ActivityCompat.requestPermissions(Friendlistpagecontact.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
//        }
//    });
//}
//    private void insertTotelData(String username, String mobileNumber, String current_time, String totel) {
//        SQLiteDatabase db = openHelper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DatabaseHandler.User_Name, username);
//        contentValues.put(DatabaseHandler.Mobile_Number, mobileNumber);
//        contentValues.put(DatabaseHandler.Current_Day, current_time);
//        contentValues.put(DatabaseHandler.Current_Balence, totel);
//        long id = db.insert(ALL_USER_TABLE, null, contentValues);
//        Log.e("Result", id + "");
//    }
//    private void insertTotel(String username, String mobileNumber, String current_time, String totel) {
//        SQLiteDatabase db = openHelper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DatabaseHandler.User_Name, username);
//        contentValues.put(DatabaseHandler.Mobile_Number, mobileNumber);
//        contentValues.put(DatabaseHandler.Current_Day, current_time);
//        contentValues.put(DatabaseHandler.Current_Balence, totel);
//        long id = db.insert(ALL_USER_TABLE, null, contentValues);
//        Log.e("Result", id + "");
//    }
//    private void updateDate(String amount, String mobileNumber) {
//        SQLiteDatabase db = openHelper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DatabaseHandler.Current_Balence, amount);
//        long id = (long) db.update(ALL_USER_TABLE, contentValues, " Mobile_Number = ? ", new String[]{mobileNumber});
//
//    }

}
