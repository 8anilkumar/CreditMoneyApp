package com.example.okcredit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.okcredit.HomepageModelClass.BALANCE_CHECK;
import static com.example.okcredit.HomepageModelClass.HOME_PAGE_BOTTOM_SETTING;

public class HomePageActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView totel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        totel = findViewById(R.id.user);

        final SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", Context.MODE_PRIVATE);
        final String user = sharedPreferences.getString("TOTEL_USER", "DEFAULT_NAME");



        recyclerView = findViewById(R.id.home_page);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        recyclerView.setLayoutManager(layoutManager);
        List<HomepageModelClass> homepageModelClasses = new ArrayList<>();
        homepageModelClasses.add(new HomepageModelClass(BALANCE_CHECK, R.drawable.ic_group_black_24dp, "CUSTOMERS", user));
        homepageModelClasses.add(new HomepageModelClass(BALANCE_CHECK, R.drawable.ic_account_balance_wallet_black, "BALANCE", "326566"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_history_black, "Account Statement"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_file_download_abc, "Download Backup"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_security_black, "Security"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_business_black_24dp, "Profile"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_account_balance_wallet_black, "Collection"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_access_alarm_black, "Reminders"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_language_black_24dp, "Language"));
        HomePageAdapter homePageAdapter = new HomePageAdapter(homepageModelClasses, new AccountStatmentInterface() {
            @Override
            public void onPositionClicked(int position) {
                if (position == 2) {
                    Intent intent = new Intent(HomePageActivity.this, AccountStatment.class);
                    Toast.makeText(HomePageActivity.this, "item:" + position, Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }

            @Override
            public void onLongClicked(int position) {

            }
        });
        recyclerView.setAdapter(homePageAdapter);
        homePageAdapter.notifyDataSetChanged();


    }

}
