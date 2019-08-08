package com.example.okcredit;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Friendlistpagecontact extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<ModelClass> rogerModelArrayList;
    TextView txtmoney, txtrecieve_money;
    Button conferm, conferm_amount_recieve;
    private LayoutInflater inflater;
    CastumerAdapter castumerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendlistpagecontact);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.chat_recyclerview);
        txtmoney = (TextView) findViewById(R.id.txtgive);
        txtrecieve_money = (TextView) findViewById(R.id.acc_payment);
        conferm = (Button) findViewById(R.id.conferm_amount);
        conferm_amount_recieve = (Button) findViewById(R.id.conferm_amount_recieve);

        rogerModelArrayList = new ArrayList<ModelClass>();
        castumerAdapter = new CastumerAdapter(rogerModelArrayList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(castumerAdapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null)
        {
            String j =(String) bundle.get("amt");
            String side =(String) bundle.get("key");
            ModelClass modelamount = new ModelClass(j);
            rogerModelArrayList .add(modelamount);
            Toast.makeText(this, "money"+j, Toast.LENGTH_SHORT).show();
        }


    }


}


