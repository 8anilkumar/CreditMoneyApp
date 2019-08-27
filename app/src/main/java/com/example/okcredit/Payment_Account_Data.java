package com.example.okcredit;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Payment_Account_Data extends AppCompatActivity {
Button give_credit,accept_payment;
ImageView back_button;
    TextView username, number;

    DatabaseHandler openHelper;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__account__data);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorToolbar));
        give_credit=(Button)findViewById(R.id.get_payment);
        accept_payment=(Button)findViewById(R.id.accept_payment);

        username = (TextView) findViewById(R.id.name);
        number = (TextView) findViewById(R.id.number);

        openHelper = new DatabaseHandler(this);


        Intent intent = getIntent();
        final String num = intent.getStringExtra("phone");
        final String name = intent.getStringExtra("name");
        Toast.makeText(this, "number" + num, Toast.LENGTH_SHORT).show();

        username.setText(name);
        number.setText(num);


        give_credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payment_Account_Data.this,GiveAmount.class);
                intent.putExtra("val", 1);
                intent.putExtra("number", num);
                intent.putExtra("name", name);
                startActivity(intent);

                //insertData(name);
                Toast.makeText(Payment_Account_Data.this, "user name is inserted", Toast.LENGTH_SHORT).show();
            }

//            private void insertData(String name) {
//
//                SQLiteDatabase db = openHelper.getWritableDatabase();
//                ContentValues contentValues = new ContentValues();
//                contentValues.put(DatabaseHandler.User_Name, name);
//                long id = db.insert(DatabaseHandler.TABLE_NAME, null, contentValues);
//                Log.e("Result", id + "");
//
//            }
        });

       accept_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payment_Account_Data.this,RecieveAmountPage.class);
                intent.putExtra("val", 0);
                intent.putExtra("number", num);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

    }

}
