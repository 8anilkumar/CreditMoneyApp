package com.example.okcredit;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GiveAmount extends AppCompatActivity {
    EditText txtruppes, adddiscription;
    Button calender, btnconferm;
    DatePickerDialog datePickerDialog;
    private static final int CAMERA_REQUEST = 500;
    ImageView back, file, camera_pic;
    LinearLayout linearLayout;

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

        namee = findViewById(R.id.name);
        number = findViewById(R.id.number);


        back = findViewById(R.id.gopayment);
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
        final int userdata = intent.getIntExtra("user", 0);
        Toast.makeText(this, "User" + userdata, Toast.LENGTH_SHORT).show();
        namee.setText(name);
        number.setText(mobile_num);


        txtruppes = findViewById(R.id.txt_rupees);
        adddiscription = findViewById(R.id.add_discription);
        calender = findViewById(R.id.btn_calender);
        btnconferm = findViewById(R.id.conferm_amount);
        linearLayout = findViewById(R.id.add_text_linearLayout);
        file = findViewById(R.id.add_file);
        camera_pic = findViewById(R.id.camera);


        camera_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });


        linearLayout.setEnabled(false);
        file.setEnabled(false);
        camera_pic.setEnabled(false);
        adddiscription.setEnabled(false);
        calender.setEnabled(false);
        btnconferm.setEnabled(false);

        adddiscription.setVisibility(View.GONE);
        calender.setVisibility(View.GONE);
        btnconferm.setVisibility(View.GONE);
        linearLayout.setVisibility(View.GONE);
        file.setVisibility(View.GONE);
        camera_pic.setVisibility(View.GONE);


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
                    linearLayout.setEnabled(false);
                    file.setEnabled(false);
                    camera_pic.setEnabled(false);


                    adddiscription.setVisibility(View.GONE);
                    calender.setVisibility(View.GONE);
                    btnconferm.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.GONE);
                    file.setVisibility(View.GONE);
                    camera_pic.setVisibility(View.GONE);

                } else {
                    adddiscription.setEnabled(true);
                    calender.setEnabled(true);
                    btnconferm.setEnabled(true);
                    linearLayout.setEnabled(true);
                    file.setEnabled(true);
                    camera_pic.setEnabled(true);
                    adddiscription.setVisibility(View.VISIBLE);
                    calender.setVisibility(View.VISIBLE);
                    btnconferm.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.VISIBLE);
                    file.setVisibility(View.VISIBLE);
                    camera_pic.setVisibility(View.VISIBLE);

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
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
                String time = simpleDateFormat.format(calendar.getTime());
                sqLiteDatabase = openHelper.getWritableDatabase();
                String amount = txtruppes.getText().toString();
                String discription = adddiscription.getText().toString();
                int paymenttype = 0;
                String rupee = String.valueOf(userdata);
                String mobile = mobile_num;
                insertData(amount, discription, paymenttype, mobile, rupee, time);
                Intent intent=new Intent(GiveAmount.this,Friendlistpagecontact.class);
                intent.putExtra("mobile", mobile);
                intent.putExtra("name", name);
                startActivity(intent);

            }
        });
    }

    public void insertData(String amount, String discription, int paymenttype, String mobile, String rupee, String time) {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHandler.Given_Money, amount);
        contentValues.put(DatabaseHandler.Given_Discription, discription);
        contentValues.put(DatabaseHandler.Money_Status, paymenttype);
        contentValues.put(DatabaseHandler.Mobile_Number, mobile);
        contentValues.put(DatabaseHandler.Given_Time, rupee);
        contentValues.put(DatabaseHandler.Give_Curren_Time, time);

        long id = db.insert(DatabaseHandler.TABLE_NAME, null, contentValues);
        Log.e("Result", id + "");
    }


}
