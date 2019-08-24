package com.example.okcredit;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.List;

public class ActivityPrivacyAndSecurity extends AppCompatActivity {
    RecyclerView recyclerView;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_and_security);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        webView = (WebView) findViewById(R.id.webview2);
        webView.loadUrl("https://www.youtube.com/watch?v=BKeEmGBltjE");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


        recyclerView = (RecyclerView) findViewById(R.id.privacyRecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), recyclerView.VERTICAL, false));
        recyclerView.setLayoutManager(layoutManager);
        List<ModleClassPrivacyAndSecurity> modleClassPrivacyAndSecurities = new ArrayList<>();
        modleClassPrivacyAndSecurities.add(new ModleClassPrivacyAndSecurity(R.drawable.ic_file_download, "Download and backup", "Take a phone backup of all customer ...."));
        modleClassPrivacyAndSecurities.add(new ModleClassPrivacyAndSecurity(R.drawable.ic_lock_outline_24dp, "Forget password", "Learn how to reset your password ....."));
        modleClassPrivacyAndSecurities.add(new ModleClassPrivacyAndSecurity(R.drawable.ic_phonelink_erase_black_24dp, "Phone got damaged or lost", "You can recover your records on any other...."));


        PrivacyAndSecurityAdapter adapter = new PrivacyAndSecurityAdapter(modleClassPrivacyAndSecurities);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

}
