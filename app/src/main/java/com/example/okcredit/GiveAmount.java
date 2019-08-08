package com.example.okcredit;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class GiveAmount extends AppCompatActivity {
EditText txtruppes,addtext;
Button calender,btnconferm;
ArrayList<ModelClass> amountList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_amount);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        txtruppes=(EditText)findViewById(R.id.txt_rupees);
        addtext=(EditText)findViewById(R.id.add_text);
        calender=(Button)findViewById(R.id.btn_calender);
        btnconferm=(Button)findViewById(R.id.conferm_amount);

        addtext.setEnabled(false);
        calender.setEnabled(false);
        btnconferm.setEnabled(false);
        addtext.setVisibility(View.GONE);
        calender.setVisibility(View.GONE);
        btnconferm.setVisibility(View.GONE);

        txtruppes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.toString().equals("")) {
                    addtext.setEnabled(false);
                    calender.setEnabled(false);
                    btnconferm.setEnabled(false);
                    addtext.setVisibility(View.GONE);
                    calender.setVisibility(View.GONE);
                    btnconferm.setVisibility(View.GONE);

                } else {
                    addtext.setEnabled(true);
                    calender.setEnabled(true);
                    btnconferm.setEnabled(true);
                    addtext.setVisibility(View.VISIBLE);
                    calender.setVisibility(View.VISIBLE);
                    btnconferm.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        btnconferm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amountrs= txtruppes.getText().toString();
                ModelClass modelamount = new ModelClass(amountrs,"right");
                amountList.add(modelamount);
                Intent intent=new Intent(GiveAmount.this,Friendlistpagecontact.class);
                intent.putExtra("amt",amountrs);
                intent.putExtra("key","right");
                startActivity(intent);
            }
        });

    }

}
