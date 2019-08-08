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
import java.util.List;

public class LearnHowToUseOkCredit extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_how_to_use_ok_credit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.learnRecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), recyclerView.VERTICAL, false));

        recyclerView.setLayoutManager(layoutManager);
        List<LearnOkCreditModelClass> learnOkCreditModelClasses = new ArrayList<>();
        learnOkCreditModelClasses.add(new LearnOkCreditModelClass(R.drawable.ic_add_person,"Add a new customer","Create a new customer account in your OKCredit...."));
        learnOkCreditModelClasses.add(new LearnOkCreditModelClass(R.drawable.ic_file_upload,"Record credit given to customer","Add credit which your customer will pay ....."));
        learnOkCreditModelClasses.add(new LearnOkCreditModelClass(R.drawable.ic_file_download,"Record payment received from customer","Add payment when your receive our money.."));
        learnOkCreditModelClasses.add(new LearnOkCreditModelClass(R.drawable.ic_close_black_24dp,"Cancel credit or payment record","Correct mistakes upto 24 hours after record"));
        learnOkCreditModelClasses.add(new LearnOkCreditModelClass(R.drawable.ic_history_black_24dp,"Check my old account statment"," you can check all your old record here...."));
        learnOkCreditModelClasses.add(new LearnOkCreditModelClass(R.drawable.ic_lock_outline_24dp,"Change password","Keep your password secret for account security...."));
        learnOkCreditModelClasses.add(new LearnOkCreditModelClass(R.drawable.ic_textsms_black_24dp,"Does my customer need OKCredit app","See how customers are notified"));
        learnOkCreditModelClasses.add(new LearnOkCreditModelClass(R.drawable.ic_share_black_24dp,"How to share OKCredit with my friend","Let other people Know about OKCredit...."));


        AdapterOkCredit adapter = new AdapterOkCredit(learnOkCreditModelClasses);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

}
