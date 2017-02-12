package com.example.android.basketball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //init the variable
    protected int scoreLeft = 0;
    protected int scoreRight = 0;
    protected int yellowLeft = 0;
    protected int yellowRight = 0;
    protected int redLeft = 0;
    protected int redRight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        the method is to change the score
        input: int * int
        output:
     */
    protected void displayCenter(int scoreL, int scoreR) {
        TextView textCenter = (TextView) findViewById(R.id.textScore);
        textCenter.setText(String.valueOf(scoreL) + " : " + String.valueOf(scoreR));
    }

    /*
        the method is describe the left team shot in.
        input:
        output:
     */
    protected void shotLeft(View v) {
        scoreLeft += 1;
        displayCenter(scoreLeft, scoreRight);
    }

    /*
        the method is describe the Right team shot in.
        input:
        output:
     */
    protected void shotRight(View v) {
        scoreRight += 1;
        displayCenter(scoreLeft, scoreRight);
    }

    /*
        the two method is describe the left team get a red card and display it.
        input:
        output:
     */
    protected void displayRedL(int redL) {
        Button button = (Button) findViewById(R.id.redLeft);
        button.setText(String.valueOf(redL));
    }

    protected void offendRedL(View v) {
        redLeft += 1;
        displayRedL(redLeft);
    }


    /*
            the two method is describe the left team get a yellow card and display it.
            input:
            output:
         */
    protected void displayYellowL(int yellowL) {
        Button button = (Button) findViewById(R.id.yellowLeft);
        button.setText(String.valueOf(yellowL));
    }

    protected void offendYellowL(View v) {
        yellowLeft += 1;
        displayYellowL(yellowLeft);
    }

    /*
            the two method is describe the right team get a yellow card and display it.
            input:
            output:
         */
    protected void displayYellowR(int yellowR) {
        Button button = (Button) findViewById(R.id.yellowRight);
        button.setText(String.valueOf(yellowR));
    }

    protected void offendYellowR(View v) {
        yellowRight += 1;
        displayYellowR(yellowRight);
    }

    /*
            the two method is describe the right team get a red card and display it.
            input:
            output:
         */
    protected void displayRedR(int RedR) {
        Button button = (Button) findViewById(R.id.redRight);
        button.setText(String.valueOf(RedR));
    }

    protected void offendRedR(View v) {
        redRight += 1;
        displayRedR(redRight);
    }

    /*
        this method is reset all data to 0
        input:
        output:
     */
    protected void buttonReset(View v) {
        redLeft = 0;
        redRight = 0;
        yellowRight = 0;
        yellowLeft = 0;
        scoreLeft = 0;
        scoreRight = 0;
        displayCenter(scoreLeft, scoreRight);
        displayRedL(redLeft);
        displayRedR(redRight);
        displayYellowL(yellowLeft);
        displayYellowR(yellowRight);
    }
}