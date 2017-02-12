package com.example.android.testforjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView textMenu1 = (TextView) findViewById(R.id.menu_item_1);
        Log.v("MainActivity",textMenu1.getText().toString());
        // Find second menu item TextView and print the text to the logs
        TextView textMenu2 = (TextView) findViewById(R.id.menu_item_2);
        Log.v("MainActivity",textMenu2.getText().toString());
        // Find third menu item TextView and print the text to the logs
        TextView textMenu3 = (TextView) findViewById(R.id.menu_item_3);
        Log.v("MainActivity",textMenu3.getText().toString());
    }
}