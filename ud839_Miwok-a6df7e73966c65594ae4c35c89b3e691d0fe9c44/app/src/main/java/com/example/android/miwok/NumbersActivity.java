package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<String> engNumbers = new ArrayList<String >();
        String [] engNum = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        for(int i = 0; i < engNum.length; i++)
            engNumbers.add(engNum[i]);

        LinearLayout colorsActivity = (LinearLayout) findViewById(R.id.activity_numbers);


    }
}
