package com.example.okcredit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AccountStatment extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseHandler openHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_statment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.accountstatment);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        recyclerView.setLayoutManager(layoutManager);
        List<ModleclassForAccountStatment> modelClasses = new ArrayList<>();

//        openHelper = new DatabaseHandler(getApplicationContext());
//        sqLiteDatabase = openHelper.getReadableDatabase();
//        cursor = openHelper.getAllData();
////        cursor = openHelper.getPaymentInfoByNumber(mobileNumber);
//        int paymenttype = 0;
//        if (cursor.moveToFirst()) {
//            do {
//                String amount, discription, user_num;
//                amount = cursor.getString(0);
//                discription = cursor.getString(1);
//                paymenttype = cursor.getInt(3);
//                user_num = cursor.getString(5);
//                ModleclassForAccountStatment modelClass = new ModleclassForAccountStatment(amount, discription, paymenttype, user_num);
//                modelClasses.add(modelClass);
//
//            }
//            while (cursor.moveToNext());
//
//            AccountStatmentAdapterClass adapter = new AccountStatmentAdapterClass(modelClasses);
//            recyclerView.setAdapter(adapter);
//            adapter.notifyDataSetChanged();
//
//        }

    }
}

