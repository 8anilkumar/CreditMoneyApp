package com.example.okcredit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
    DatabaseHandler openHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    String amount;
    String allTransaction = "";
    int totel_transaction = 0;
    ImageView imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        totel = findViewById(R.id.user);

        imgback = findViewById(R.id.back);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", Context.MODE_PRIVATE);
        final String user = sharedPreferences.getString("TOTEL_USER", "DEFAULT_NAME");



        recyclerView = findViewById(R.id.home_page);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        recyclerView.setLayoutManager(layoutManager);
        List<HomepageModelClass> homepageModelClasses = new ArrayList<>();


        openHelper = new DatabaseHandler(getApplicationContext());
        sqLiteDatabase = openHelper.getReadableDatabase();
        cursor = openHelper.getAllData();
        if (cursor.moveToFirst()) {
            do {
                amount = cursor.getString(0);

                int variable = Integer.parseInt(amount);
                totel_transaction = totel_transaction + variable;
            }
            while (cursor.moveToNext());

        }
        allTransaction = String.valueOf(totel_transaction);

        homepageModelClasses.add(new HomepageModelClass(BALANCE_CHECK, R.drawable.ic_group_black_24dp, "CUSTOMERS", user));
        homepageModelClasses.add(new HomepageModelClass(BALANCE_CHECK, R.drawable.ic_account_balance_wallet_black, "BALANCE", allTransaction));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_history_black, "Account Statement"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_file_download_abc, "Download Backup"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_security_black, "Security"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_business_black_24dp, "Profile"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_account_balance_wallet_black, "Collection"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_access_alarm_black, "Reminders"));
        homepageModelClasses.add(new HomepageModelClass(HOME_PAGE_BOTTOM_SETTING, R.drawable.ic_language_black_24dp, "Language                                         ENGLISH"));
        HomePageAdapter homePageAdapter = new HomePageAdapter(homepageModelClasses, new AccountStatmentInterface() {
            @Override
            public void onPositionClicked(int position) {
                if (position == 2) {
                    Intent intent = new Intent(HomePageActivity.this, AccountStatment.class);

                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(HomePageActivity.this, OkCreditSecurity.class);

                    startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(HomePageActivity.this, UserProfile.class);

                    startActivity(intent);
                }
                if (position == 6) {
                    Intent intent = new Intent(HomePageActivity.this, CollectionMoneyActivity.class);

                    startActivity(intent);
                }
                if (position == 7) {
                    Intent intent = new Intent(HomePageActivity.this, ReminderSetting.class);

                    startActivity(intent);
                }
                if (position == 8) {
                    Intent intent = new Intent(HomePageActivity.this, Language.class);

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
