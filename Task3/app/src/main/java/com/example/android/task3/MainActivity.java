package com.example.android.task3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    *  The method check the answer and return the point
     */
    private int pointReturn()
    {
        RadioButton[] radioButtons = {(RadioButton) findViewById(R.id.question1_1), (RadioButton) findViewById(R.id.question2_3)};
        CheckBox[] checkBoxes = {(CheckBox) findViewById(R.id.question3_1),
                (CheckBox) findViewById(R.id.question3_2),
                (CheckBox) findViewById(R.id.question3_3),
                (CheckBox) findViewById(R.id.question3_4)};
        int point = 0;
        for(int i = 0; i < radioButtons.length; i++)
        {
            if(radioButtons[i].isChecked())
                point += 5;
        }
        boolean flag = true;
        boolean[] answer = {true, false, true, true};
        for(int i = 0; i < checkBoxes.length; i++)
        {
            if(answer[i] != checkBoxes[i].isChecked()) {
                flag = false;
                break;
            }
        }
        if(flag)
            point += 5;
        EditText ansEdit = (EditText) findViewById(R.id.question4);
        String textAns = ansEdit.getText().toString();

        if(textAns.equals(getResources().getString(R.string.question4_answer)))
        {
            point += 5;
        }

        return point;
    }

    /*
    *   when click the submit button, check the point and return.
     */
    public void submitAnswer(View view){
        int point = pointReturn();
        String  report = "you get " + String.valueOf(point) + " / 20 ";
        Toast toast = Toast.makeText(this, report , Toast.LENGTH_SHORT);
        toast.show();
    }

}
