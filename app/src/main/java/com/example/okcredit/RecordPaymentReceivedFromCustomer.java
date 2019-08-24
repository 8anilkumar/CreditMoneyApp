package com.example.okcredit;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class RecordPaymentReceivedFromCustomer extends AppCompatActivity {
    ImageSwitcher imageSwitcher;
    ImageView imgnext, imgpre;
    int imageswitchId[] = {R.drawable.mob_aaa, R.drawable.mob_bbb, R.drawable.mob_ccc};
    int count = imageswitchId.length;
    int currentIndex = -1;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_payment_received_from_customer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecordPaymentReceivedFromCustomer.this, LearnHowToUseOkCredit.class);
                startActivity(intent);
            }
        });
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
        imgnext = (ImageView) findViewById(R.id.right);
        imgpre = (ImageView) findViewById(R.id.left);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));


                return imageView;
            }
        });

        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex < imageswitchId.length - 1)
                    currentIndex = currentIndex + 1;
                imageSwitcher.setImageResource(imageswitchId[currentIndex]);

            }
        });

        imgpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex > 0) {
                    currentIndex = currentIndex - 1;
                    imageSwitcher.setImageResource(imageswitchId[currentIndex]);
                }
            }
        });


    }

}
