package com.example.okcredit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OkCreditSecurity extends AppCompatActivity {
    ImageView imgback;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_credit_security);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgback = findViewById(R.id.back);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OkCreditSecurity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.security_okcredit);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        recyclerView.setLayoutManager(layoutManager);
        List<ModelClassForOkCreditSecutity> modelClassForOkCreditSecutities = new ArrayList<>();

        modelClassForOkCreditSecutities.add(new ModelClassForOkCreditSecutity("Update Password"));
        modelClassForOkCreditSecutities.add(new ModelClassForOkCreditSecutity ( "App Lock                                               OFF"));
        modelClassForOkCreditSecutities.add(new ModelClassForOkCreditSecutity( "Payment Password                             OFF"));
        modelClassForOkCreditSecutities.add(new ModelClassForOkCreditSecutity( "Sign out all devices"));

        AdapterClassForOkcreditSecurity adapterClassForOkcreditSecurity= new AdapterClassForOkcreditSecurity(modelClassForOkCreditSecutities, new SecurityInterface() {
            @Override
            public void onPositionClicked(int position) {
                if (position == 0) {
                    Intent intent = new Intent(OkCreditSecurity.this, UpdatePasswordActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onLongClicked(int position) {

            }
        });
        recyclerView.setAdapter(adapterClassForOkcreditSecurity);
        adapterClassForOkcreditSecurity.notifyDataSetChanged();

    }

    }


