package com.example.okcredit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.widget.Toolbar;

public class PrivacyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_page);
        TextView textView=(TextView)findViewById(R.id.texurl);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://okcredit.in/privacy'> Know more about OkCredit </a>";
        textView.setText(Html.fromHtml(text));

    }


}
