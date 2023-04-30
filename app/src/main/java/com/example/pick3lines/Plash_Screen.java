package com.example.pick3lines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Plash_Screen extends AppCompatActivity {

    private static int PLASH_TIMER=2000;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plash_screen);

        progressBar = findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent myIntent = new Intent(Plash_Screen.this, MainActivity.class);
                progressBar.setVisibility(View.GONE);
                startActivity(myIntent);
                finish();



            }
        },PLASH_TIMER);
    }
}