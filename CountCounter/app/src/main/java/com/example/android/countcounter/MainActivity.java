package com.example.android.countcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected int scoreRecordA = 0;
    protected int scoreRecordB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // method for teamA
    /*
        the method is to display the score on the counter textView
        input: int;
        output: ;
    */
    protected void displayForCounter(int score) {
        TextView textForCounter = (TextView) findViewById(R.id.textViewA_count);
        textForCounter.setText(String.valueOf(score));
    }

    /*
        the method is for click the button + 3 points, every click you will get 3 points
         input: ;
         output: ;
     */
    public void addThreeForA(View v) {
        scoreRecordA += 3;
        displayForCounter(scoreRecordA);
    }

    /*
        the method is for click the button + 2 points, every click you will get 2 points
         input: ;
         output: ;
     */
    public void addTwoForA(View v) {
        scoreRecordA += 2;
        displayForCounter(scoreRecordA);
    }

    /*
        the method is for click the button free throw, every click you will get 1 points
         input: ;
         output: ;
     */
    public void addOneForA(View v) {
        scoreRecordA += 1;
        displayForCounter(scoreRecordA);
    }

    // method for teamA
    /*
        the method is to display the score on the counter textView
        input: int;
        output: ;
    */
    protected void displayForCounterB(int score) {
        TextView textForCounter = (TextView) findViewById(R.id.textViewB_count);
        textForCounter.setText(String.valueOf(score));
    }

    /*
        the method is for click the button + 3 points, every click you will get 3 points
         input: ;
         output: ;
     */
    public void addThreeForB(View v) {
        scoreRecordB += 3;
        displayForCounterB(scoreRecordB);
    }

    /*
        the method is for click the button + 2 points, every click you will get 2 points
         input: ;
         output: ;
     */
    public void addTwoForB(View v) {
        scoreRecordB += 2;
        displayForCounterB(scoreRecordB);
    }

    /*
        the method is for click the button free throw, every click you will get 1 points
         input: ;
         output: ;
     */
    public void addOneForB(View v) {
        scoreRecordB += 1;
        displayForCounterB(scoreRecordB);
    }

    /*
        the method is reset two team score to 0
        input: ;
        output: ;
    */
    public void oncllickReset(View v){
        scoreRecordA = 0;
        scoreRecordB = 0;
        displayForCounter(scoreRecordA);
        displayForCounterB(scoreRecordB);
    }
}
