package com.example.okcredit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

import java.util.ArrayList;
import java.util.List;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        number = findViewById(R.id.number);


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

        cursor = openHelper.getAllUserData();
        Toast.makeText(this, "ghfhhfh" + mobileNumber, Toast.LENGTH_SHORT).show();
        if (cursor.moveToFirst()) {
            do {

                String name = cursor.getString(0);
                String status = cursor.getString(1);
                int totel_money = cursor.getInt(2);
                String phone = cursor.getString(3);
                ModelClassForAddedCustomer contacts = new ModelClassForAddedCustomer(name, status, totel_money, phone);
                modelClassForAddedCustomers.add(contacts);
                rows = cursor.getCount();


            }
            while (cursor.moveToNext());

        }

        AdapterClassAllReadyAddedCustomer adapter = new AdapterClassAllReadyAddedCustomer(modelClassForAddedCustomers, new DashbordlistnerClassInterface() {
            @Override
            public void onPositionClicked(int position) {

                Intent intent = new Intent(MainActivity.this, Friendlistpagecontact.class);
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
//
//        Toast.makeText(this, "totel user"+rows, Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(MainActivity.this,HomePageActivity.class);
//        intent.putExtra("totel_customer",rows);
//        startActivity(intent);


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
