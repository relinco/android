package com.example.inco.myapplication;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface csFont = Typeface.createFromAsset(this.getAssets(), "fonts/cs.ttf");
        TextView text1 = (TextView) findViewById(R.id.text1);
        text1.setTypeface(csFont);
        text1.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView text2 = (TextView) findViewById(R.id.text2);
        text2.setTypeface(csFont);
        text2.setGravity(Gravity.CENTER_HORIZONTAL);
    }
}
