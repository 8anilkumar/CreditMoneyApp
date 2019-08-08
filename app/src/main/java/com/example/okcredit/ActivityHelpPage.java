package com.example.okcredit;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class ActivityHelpPage extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.txthelp);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), recyclerView.VERTICAL, false));

        recyclerView.setLayoutManager(layoutManager);
        List<ModelHelpClass> modelHelpClassList = new ArrayList<>();
        modelHelpClassList.add(new ModelHelpClass(R.drawable.ic_opacity_black_24dp,"Learn How to use","App Usage Tutorial"));
        modelHelpClassList.add(new ModelHelpClass(R.drawable.ic_lock_outline_24dp,"Privay & Security","Your record are completely secure Learn....."));

        Adapter adapter = new Adapter(modelHelpClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
