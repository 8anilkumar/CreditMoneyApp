package com.example.okcredit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Friendlistpagecontact extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView txtmoney, txtrecieve_money, status;
    Button conferm, conferm_amount_recieve;
    Button give_payment, accept_payment;
    DatabaseHandler openHelper;
    SQLiteDatabase sqLiteDatabase;
    ImageView call, send, backpage;
    TextView user_name, user_number;
    Cursor cursor;
    String mobileNumber = "";
    String username = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendlistpagecontact);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        status = findViewById(R.id.status_amount);
        user_name = findViewById(R.id.name);
        user_number = findViewById(R.id.number);

        call = findViewById(R.id.call);
        send = findViewById(R.id.message);
        give_payment = findViewById(R.id.get_payment_money);
        accept_payment = findViewById(R.id.accept_payment_money);

//        backpage=(ImageView) findViewById(R.id.back);
//        backpage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Friendlistpagecontact.this,Payment_Account_Data.class);
//                startActivity(intent);
//            }
//        });

        Intent intent = getIntent();

        username = intent.getStringExtra("name");
        mobileNumber = intent.getStringExtra("mobile");


        user_name.setText(username);
        user_number.setText(mobileNumber);


        give_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Friendlistpagecontact.this, GiveAmount.class);
                intent.putExtra("val", 1);
                intent.putExtra("number", mobileNumber);
                intent.putExtra("name", username);
                startActivity(intent);
            }
        });


        accept_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Friendlistpagecontact.this, RecieveAmountPage.class);
                intent.putExtra("val", 1);
                intent.putExtra("number", mobileNumber);
                intent.putExtra("name", username);
                startActivity(intent);
            }
        });
        txtmoney = findViewById(R.id.txtgive);
        txtrecieve_money = findViewById(R.id.acc_payment);
//        conferm = (Button) findViewById(R.id.conferm_amount);
//        conferm_amount_recieve = (Button) findViewById(R.id.conferm_amount_recieve);

        recyclerView = findViewById(R.id.chat_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        recyclerView.setLayoutManager(layoutManager);
        List<ModelClass> modelClasses = new ArrayList<>();

        openHelper = new DatabaseHandler(getApplicationContext());
        sqLiteDatabase = openHelper.getReadableDatabase();
        //cursor = openHelper.getAllData();
        cursor = openHelper.getPaymentInfoByNumber(mobileNumber);
        int paymenttype = 0;
        if (cursor.moveToFirst()) {
            do {
                String amount, discription, user_num;
                amount = cursor.getString(0);
                discription = cursor.getString(1);
                paymenttype = cursor.getInt(3);
                user_num = cursor.getString(5);
                ModelClass modelClass = new ModelClass(amount, discription, paymenttype, user_num);
                modelClasses.add(modelClass);

            }
            while (cursor.moveToNext());

            CastumerAdapter adapter = new CastumerAdapter(modelClasses);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intcall = new Intent(Intent.ACTION_CALL);
                if (mobileNumber.trim().isEmpty()) {
                    intcall.setData(Uri.parse("tel:5677889"));
                } else {
                    intcall.setData(Uri.parse("tel:" + mobileNumber));
                }
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Friendlistpagecontact.this, "Please grant Permission", Toast.LENGTH_SHORT).show();
                    requestPermission();
                } else {
                    startActivity(intcall);
                }
            }

            private void requestPermission() {
                ActivityCompat.requestPermissions(Friendlistpagecontact.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
        });

    }
}



