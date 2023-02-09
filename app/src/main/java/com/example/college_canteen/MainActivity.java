package com.example.college_canteen;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity{
    private static int TIME_OUT = 1000;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View myLayout = findViewById(R.id.main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, login_s.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);

    }
}