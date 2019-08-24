package com.example.okcredit;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        mobileNumber = intent.getStringExtra("mobile");


        home_btn = (ImageView) findViewById(R.id.navigation_home);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });



        contact_list=(Button)findViewById(R.id.account_user);
        contact_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ContactListPage.class);
                startActivity(intent);
            }
        });


//        recyclerView = (RecyclerView) findViewById(R.id.chat_recyclerview);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), recyclerView.VERTICAL, false));
//
//        recyclerView.setLayoutManager(layoutManager);
//        List<ModelClassForAddedCustomer> modelClassForAddedCustomers = new ArrayList<>();

//        openHelper = new DatabaseHandler(getApplicationContext());
//        sqLiteDatabase = openHelper.getReadableDatabase();
//
//        cursor = openHelper.getPaymentInfoByNumber(mobileNumber);
//        if(cursor.moveToFirst()) {
//            do {
//                String name;
//                name = cursor.getString(4);
//                ModelClassForAddedCustomer modelClassForAddedCustomer = new ModelClassForAddedCustomer(name);
//                modelClassForAddedCustomers.add(modelClassForAddedCustomer);
//            }
//            while (cursor.moveToNext());
//        }
//
//        AdapterClassAllReadyAddedCustomer adapter = new AdapterClassAllReadyAddedCustomer(modelClassForAddedCustomers);
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//





        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
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
