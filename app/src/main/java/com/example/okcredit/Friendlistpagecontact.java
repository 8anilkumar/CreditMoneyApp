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
    TextView txtmoney;
    TextView txtrecieve_money;
    TextView status;
    Button conferm, conferm_amount_recieve;
    Button give_payment, accept_payment;
    DatabaseHandler openHelper;
    SQLiteDatabase sqLiteDatabase;
    ImageView call, send, backpage;
    TextView user_name, user_number;
    Cursor cursor;
    String mobileNumber = "";
    String username = "";
    int userstatus = 0;
    int user_totel_amount = 0;
    int totel = 0;
    int user_totel = 0;
    int customer_totel_amount = 0;

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
        userstatus = intent.getIntExtra("new", 0);



        user_name.setText(username);
        user_number.setText(mobileNumber);


        give_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Friendlistpagecontact.this, GiveAmount.class);
                intent.putExtra("number", mobileNumber);
                intent.putExtra("name", username);
                intent.putExtra("user", totel);
//                Toast.makeText(Friendlistpagecontact.this, "user" + totel, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


        accept_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Friendlistpagecontact.this, RecieveAmountPage.class);
                intent.putExtra("number", mobileNumber);
                intent.putExtra("name", username);
                intent.putExtra("receiver", user_totel);
//                Toast.makeText(Friendlistpagecontact.this, "customer" + user_totel, Toast.LENGTH_SHORT).show();
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
        int time = 0;
        if (cursor.moveToFirst()) {
            do {
                String amount;
                String discription;
                String user_num;
                int status;
                amount = cursor.getString(0);
                discription = cursor.getString(1);
                paymenttype = cursor.getInt(2);
                user_num = cursor.getString(4);
                status = cursor.getInt(5);
                time = cursor.getInt(6);
                Toast.makeText(this, "Status:-" + status, Toast.LENGTH_SHORT).show();
                ModelClass modelClass = new ModelClass(amount, discription, paymenttype, user_num, status);
                modelClasses.add(modelClass);

                if (paymenttype == 0) {
                    int count = Integer.parseInt(amount);
                    user_totel_amount = user_totel_amount + count;
                } else {
                    int count = Integer.parseInt(amount);
                    customer_totel_amount = customer_totel_amount + count;
                }

            }
            while (cursor.moveToNext());

            if (user_totel_amount > customer_totel_amount) {
                totel = user_totel_amount - customer_totel_amount;
                Toast.makeText(this, "Due_amount" + totel, Toast.LENGTH_SHORT).show();

            } else {
                user_totel = customer_totel_amount - user_totel_amount;
                Toast.makeText(this, "Advance_amount" + user_totel, Toast.LENGTH_SHORT).show();

            }

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



