package com.example.android.onmusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* initialize the textView */
        TextView localMusicText = (TextView) findViewById(R.id.local_music_describe);
        /* set the onClickListener for the textView */
        localMusicText.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        Intent intent = new Intent(MainActivity.this, OnPlay.class);
                        startActivity(intent);
                    }
                }
        );

        /* initialize the textView */
        TextView shopListText = (TextView) findViewById(R.id.music_shop_describe);
        /* set the onClickListener for the textView */
        shopListText.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        Intent intent = new Intent(MainActivity.this, MusicShop.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
