package com.example.okcredit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.hardware.camera2.params.BlackLevelPattern.COUNT;
import static android.icu.text.MessagePattern.ArgType.SELECT;
import static com.example.okcredit.DatabaseHandler.ALL_USER_TABLE;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button contact_list;
    ImageView home_btn;
    RecyclerView recyclerView;
    DatabaseHandler openHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    String mobileNumber = "";
    TextView number;
    TextView bar;
    ImageView progress;
    ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    ImageView user_image;
    TextView name_user;
    String name = "";
    String phone = "";
    private String[] mArrayNames = new String[]{};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        number = findViewById(R.id.number);
        progress = findViewById(R.id.progress);
        progressBar = findViewById(R.id.progressBar);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus < 100) {
                            progressStatus += 10;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(progressStatus);
                                    if (progressStatus == 100) {
                                        progressBar.setProgress(progressStatus);
                                        Toast.makeText(MainActivity.this, "Download Complete", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

            }
        });

        user_image = (ImageView) findViewById(R.id.user_img_pro);
        name_user = (TextView) findViewById(R.id.name);
        user_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserProfile.class);
                startActivity(intent);
            }
        });
        name_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserProfile.class);
                startActivity(intent);
            }
        });

        home_btn = findViewById(R.id.navigation_home);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });


        contact_list = findViewById(R.id.account_user);
        contact_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ContactListPage.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.added_customer);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        recyclerView.setLayoutManager(layoutManager);
        List<ModelClassForAddedCustomer> modelClassForAddedCustomers = new ArrayList<>();

        openHelper = new DatabaseHandler(getApplicationContext());
        sqLiteDatabase = openHelper.getReadableDatabase();
        String srtcount = "";
         int rows = 0;
        String current_balenc = "";

        cursor = openHelper.getAllUserData();
        if (cursor.moveToFirst()) {
            do {

                name = cursor.getString(0);
                phone = cursor.getString(1);
                String time = cursor.getString(2);
                current_balenc = cursor.getString(3);
                String user_img = name.charAt(0) + "";
                ModelClassForAddedCustomer contacts = new ModelClassForAddedCustomer(name, phone, time, current_balenc, user_img);
                modelClassForAddedCustomers.add(contacts);
                rows = cursor.getCount();


            }
            while (cursor.moveToNext());

        }


        AdapterClassAllReadyAddedCustomer adapter = new AdapterClassAllReadyAddedCustomer(modelClassForAddedCustomers, new DashbordlistnerClassInterface() {
            @Override
            public void onPositionClicked(int position) {

                Intent intent = new Intent(MainActivity.this, Friendlistpagecontact.class);
                intent.putExtra("mobile", phone);
                Toast.makeText(MainActivity.this, "number is " + phone, Toast.LENGTH_SHORT).show();
                intent.putExtra("name", name);
                Toast.makeText(MainActivity.this, "name" + name, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }

            @Override
            public void onLongClicked(int position) {

            }
        });
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("TOTEL_USER", String.valueOf(rows));
        editor.commit();


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_name) {


            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

            Intent intent=new Intent(MainActivity.this,ActivityHelpPage.class);
            startActivity(intent);
           
        } else if (id == R.id.nav_slideshow) {
            openUrl("https://okcredit.in");
            
        } else if (id == R.id.nav_tools) {

            Intent intent=new Intent(MainActivity.this,PrivacyPage.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            Intent intent=new Intent(MainActivity.this,SignOutPage.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openUrl(String url) {
        Uri uri=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

}
