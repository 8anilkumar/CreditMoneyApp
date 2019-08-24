package com.example.okcredit;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class ActivityHelpPage extends AppCompatActivity {
    RecyclerView recyclerView;
    Button whatsApp;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHelpPage.this, MainActivity.class);
                startActivity(intent);
            }
        });


        whatsApp = (Button) findViewById(R.id.whatsapp);
        recyclerView = (RecyclerView) findViewById(R.id.txthelp);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), recyclerView.VERTICAL, false));

        recyclerView.setLayoutManager(layoutManager);
        List<ModelHelpClass> modelHelpClassList = new ArrayList<>();
        modelHelpClassList.add(new ModelHelpClass(R.drawable.ic_opacity_black_24dp,"Learn How to use","App Usage Tutorial"));
        modelHelpClassList.add(new ModelHelpClass(R.drawable.ic_lock_outline_24dp,"Privay & Security","Your record are completely secure Learn....."));


        Adapter adapter = new Adapter(modelHelpClassList, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                // callback performed on click
                if (position == 0) {
                    Intent intent = new Intent(ActivityHelpPage.this, LearnHowToUseOkCredit.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(ActivityHelpPage.this, ActivityPrivacyAndSecurity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onLongClicked(int position) {

            }
        });

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        whatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager pm = getPackageManager();
                try {
                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");
                    String text = " I have a question regarding OkCredit ";
                    PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);

                    waIntent.setPackage("com.whatsapp");
                    waIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(waIntent, "Share with"));
                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(ActivityHelpPage.this, "Whatsapp Not Installde", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
