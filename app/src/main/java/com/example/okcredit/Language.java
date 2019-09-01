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

public class Language extends AppCompatActivity {

    ImageView imgback;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgback = findViewById(R.id.back);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Language.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.language);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        recyclerView.setLayoutManager(layoutManager);
        List<ModelClassForLanguage> modelClassForLanguages = new ArrayList<>();
        modelClassForLanguages.add(new ModelClassForLanguage("भारत की भाषाएँ"));
        modelClassForLanguages.add(new ModelClassForLanguage("Uurdu"));
        modelClassForLanguages.add(new ModelClassForLanguage("Marathi"));
        modelClassForLanguages.add(new ModelClassForLanguage("Panjabi"));
        modelClassForLanguages.add(new ModelClassForLanguage("भारतामधील भाषा"));
        modelClassForLanguages.add(new ModelClassForLanguage("Hindi"));
        modelClassForLanguages.add(new ModelClassForLanguage("Linglish"));
        modelClassForLanguages.add(new ModelClassForLanguage("ભારતની ભાષાઓની સૂચી"));
        modelClassForLanguages.add(new ModelClassForLanguage("ভারতের ভাষা"));

        LanguageAdapter languageAdapter = new LanguageAdapter(modelClassForLanguages);
        recyclerView.setAdapter(languageAdapter);
        languageAdapter.notifyDataSetChanged();

    }

}
