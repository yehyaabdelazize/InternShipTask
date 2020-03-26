package com.example.internshiptask.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.internshiptask.R;
import com.example.internshiptask.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding splashBinding;
    private static final int timeOut =3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashBinding= DataBindingUtil.setContentView(this,R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextIntent = new Intent(SplashActivity.this, YTubeChannelsActivity.class);
                startActivity(nextIntent);
                finish();
            }
        },timeOut);
    }

    @Override
    public void finish() {
        super.finish();
    }
}
