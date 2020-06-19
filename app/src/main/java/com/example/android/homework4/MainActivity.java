package com.example.android.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static boolean RUN_ONCE = true;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewRandomNumber = findViewById(R.id.textViewRandomNumber);
        Button buttonBack = findViewById(R.id.buttonBack);
        Button buttonForward = findViewById(R.id.buttonForward);

        Random r = new Random();
        int i = r.nextInt(100);
        textViewRandomNumber.setText(getString(R.string.url) + String.valueOf(i));

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (RUN_ONCE == true) finish();
                else MainActivity.super.onBackPressed();
            }
        });

        buttonForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RUN_ONCE = false;
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}