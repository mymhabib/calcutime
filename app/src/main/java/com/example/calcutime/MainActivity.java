package com.example.calcutime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonCalculator;
    Button buttonTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalculator = findViewById(R.id.buttonCalculator);
        buttonTimer = findViewById(R.id.buttonTimer);

        buttonCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCalculator = new Intent(MainActivity.this, calculatorActivity.class);
                startActivity(intentCalculator);
            }
        });
        buttonTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTimer = new Intent(MainActivity.this, countdownTimer.class);
                startActivity(intentTimer);
            }
        });

    }
}