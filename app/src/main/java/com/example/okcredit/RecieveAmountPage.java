package com.example.okcredit;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RecieveAmountPage extends AppCompatActivity {
    EditText txtruppes_rec,addtext_rec;
    Button calender_rec,btnconferm_rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_amount_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        txtruppes_rec=(EditText)findViewById(R.id.txt_recieve);
        addtext_rec=(EditText)findViewById(R.id.add_text_recieve);
        calender_rec=(Button)findViewById(R.id.btn_calender_recieve);
        btnconferm_rec=(Button)findViewById(R.id.conferm_amount_recieve);

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



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
