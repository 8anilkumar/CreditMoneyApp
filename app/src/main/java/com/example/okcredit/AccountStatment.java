package com.example.okcredit;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_statment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountStatment.this,HomePageActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.accountstatment);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        recyclerView.setLayoutManager(layoutManager);
        List<ModleclassForAccountStatment> modleclassForAccountStatments = new ArrayList<>();

        openHelper = new DatabaseHandler(getApplicationContext());
        sqLiteDatabase = openHelper.getReadableDatabase();
        cursor = openHelper.getAllData();
        int paymenttype = 0;
        String time = "";
        String date = "";
        String name = "";
        if (cursor.moveToFirst()) {
            do {
                String amount;
                String discription;
                amount = cursor.getString(0);
                paymenttype = cursor.getInt(2);
                time = cursor.getString(6);
                date = cursor.getString(7);
                name = cursor.getString(8);
                //Toast.makeText(this, "datadata"+name, Toast.LENGTH_SHORT).show();
                ModleclassForAccountStatment modelClass = new ModleclassForAccountStatment(amount, name, paymenttype, time, date);
                modleclassForAccountStatments.add(modelClass);


            }
            while (cursor.moveToNext());
            AccountStatmentAdapterClass adapter = new AccountStatmentAdapterClass(modleclassForAccountStatments);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }

    }

    }


