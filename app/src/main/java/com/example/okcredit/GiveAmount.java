package com.example.okcredit;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GiveAmount extends AppCompatActivity {
    EditText txtruppes, adddiscription;
    Button calender, btnconferm;
    DatePickerDialog datePickerDialog;
    ImageView back;
    TextView namee, number;
    List<ModelClass> amountList = new ArrayList<>();

    DatabaseHandler openHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_amount);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        openHelper = new DatabaseHandler(this);

        namee = (TextView) findViewById(R.id.name);
        number = (TextView) findViewById(R.id.number);


        back = (ImageView) findViewById(R.id.gopayment);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiveAmount.this, Payment_Account_Data.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        final String mobile_num = intent.getStringExtra("number");
        final String name = intent.getStringExtra("name");


        namee.setText((CharSequence) name);
        number.setText((CharSequence) mobile_num);


        txtruppes = (EditText) findViewById(R.id.txt_rupees);
        adddiscription = (EditText) findViewById(R.id.add_discription);
        calender = (Button) findViewById(R.id.btn_calender);
        btnconferm = (Button) findViewById(R.id.conferm_amount);


        adddiscription.setEnabled(false);
        calender.setEnabled(false);
        btnconferm.setEnabled(false);
        adddiscription.setVisibility(View.GONE);
        calender.setVisibility(View.GONE);
        btnconferm.setVisibility(View.GONE);

        txtruppes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.toString().equals("")) {
                    adddiscription.setEnabled(false);
                    calender.setEnabled(false);
                    btnconferm.setEnabled(false);
                    adddiscription.setVisibility(View.GONE);
                    calender.setVisibility(View.GONE);
                    btnconferm.setVisibility(View.GONE);

                } else {
                    adddiscription.setEnabled(true);
                    calender.setEnabled(true);
                    btnconferm.setEnabled(true);
                    adddiscription.setVisibility(View.VISIBLE);
                    calender.setVisibility(View.VISIBLE);
                    btnconferm.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });

        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePickerDialog = new DatePickerDialog(GiveAmount.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    }
                }, 0, 0, 0);
                datePickerDialog.show();

            }


        });


        btnconferm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase = openHelper.getWritableDatabase();
                String amount = txtruppes.getText().toString();
                String discription = adddiscription.getText().toString();
                int paymenttype = 0;
                String mobile = mobile_num;
                insertData(amount, discription, paymenttype, mobile);
                Toast.makeText(GiveAmount.this, "data is inserted", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(GiveAmount.this,Friendlistpagecontact.class);
                intent.putExtra("mobile", mobile);
                intent.putExtra("name", name);
                startActivity(intent);

            }
        });
    }

    public void insertData(String amount, String discription, int paymenttype, String mobile) {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHandler.Given_Money, amount);
        contentValues.put(DatabaseHandler.Given_Discription, discription);
        contentValues.put(DatabaseHandler.Money_Status, paymenttype);
        contentValues.put(DatabaseHandler.Mobile_Number, mobile);
        long id = db.insert(DatabaseHandler.TABLE_NAME, null, contentValues);
        Log.e("Result", id + "");
    }
}
