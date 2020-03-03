package com.example.efarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.efarming.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(6000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent homeIntent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(homeIntent);
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
