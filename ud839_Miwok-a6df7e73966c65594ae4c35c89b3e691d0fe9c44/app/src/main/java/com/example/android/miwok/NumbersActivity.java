package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class NumbersActivity extends AppCompatActivity {
    String [] engNumbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        for (int i = 0; i < engNumbers.length; i++)
            Log.i("NumbersActivity", "word at index " + i + " : " + engNumbers[i]);
    }
}
