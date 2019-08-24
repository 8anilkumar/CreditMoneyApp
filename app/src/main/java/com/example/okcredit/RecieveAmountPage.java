package com.example.okcredit;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecieveAmountPage extends AppCompatActivity {
    EditText txtruppes_rec,addtext_rec;
    Button calender_rec,btnconferm_rec;
    DatePickerDialog datePickerDialog;
    TextView namee, number;
    ArrayList<ModelClass> recieve_amountList = new ArrayList<>();

    DatabaseHandler openHelper;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_amount_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        openHelper = new DatabaseHandler(this);
        namee = (TextView) findViewById(R.id.name);
        number = (TextView) findViewById(R.id.number);

        Intent intent = getIntent();
        final String mobile_num = intent.getStringExtra("number");
        final String name = intent.getStringExtra("name");

        namee.setText((CharSequence) name);
        number.setText((CharSequence) mobile_num);

        txtruppes_rec = (EditText) findViewById(R.id.txt_recieve);
        addtext_rec = (EditText) findViewById(R.id.add_recieve_discription);
        calender_rec = (Button) findViewById(R.id.btn_calender_recieve);
        btnconferm_rec = (Button) findViewById(R.id.conferm_amount_recieve);

        addtext_rec.setEnabled(false);
        calender_rec.setEnabled(false);
        btnconferm_rec.setEnabled(false);
        addtext_rec.setVisibility(View.GONE);
        calender_rec.setVisibility(View.GONE);
        btnconferm_rec.setVisibility(View.GONE);

        txtruppes_rec.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.toString().equals("")) {
                    addtext_rec.setEnabled(false);
                    calender_rec.setEnabled(false);
                    btnconferm_rec.setEnabled(false);
                    addtext_rec.setVisibility(View.GONE);
                    calender_rec.setVisibility(View.GONE);
                    btnconferm_rec.setVisibility(View.GONE);

                } else {
                    addtext_rec.setEnabled(true);
                    calender_rec.setEnabled(true);
                    btnconferm_rec.setEnabled(true);
                    addtext_rec.setVisibility(View.VISIBLE);
                    calender_rec.setVisibility(View.VISIBLE);
                    btnconferm_rec.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        calender_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePickerDialog = new DatePickerDialog(RecieveAmountPage.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    }
                }, 0, 0, 0);
                datePickerDialog.show();
            }

        });

        btnconferm_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase = openHelper.getWritableDatabase();
                String amount = txtruppes_rec.getText().toString();
                String discription = addtext_rec.getText().toString();
                int paymenttype = 1;
                String mobile = mobile_num;

                insertData(amount, discription, paymenttype, mobile);
                Toast.makeText(RecieveAmountPage.this, "data is inserted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RecieveAmountPage.this, Friendlistpagecontact.class);
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


