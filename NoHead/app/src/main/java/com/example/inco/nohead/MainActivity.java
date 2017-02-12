package com.example.inco.nohead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface loliFont = Typeface.createFromAsset(this.getAssets(), "fonts/loli.ttf");
        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        TextView text1 = (TextView) findViewById(R.id.textView) ;
        TextView text2 = (TextView) findViewById(R.id.textView2) ;
        TextView text3 = (TextView) findViewById(R.id.textView3) ;
        TextView text4 = (TextView) findViewById(R.id.textView4) ;
        button1.setTypeface(loliFont);
        button2.setTypeface(loliFont);
        text1.setTypeface(loliFont);
        text2.setTypeface(loliFont);
        text3.setTypeface(loliFont);
        text4.setTypeface(loliFont);
    }
}
