package com.toomanycooksapp.mathapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class LessonActivity extends ActionBarActivity {

    // This is sent in the intent to the LessonActivity
    // 0 -> addition
    // 1 -> subtraction
    // 2 -> multiplication
    // 3 -> division
    int lesson;

    Button lessonButton = null;
    Button gameButton = null;
    Button fcButton = null;
    Button quizButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        // Get called intent and integer corresponding to correct lesson
        Intent calledBy = getIntent();
        lesson = calledBy.getExtras().getInt("lesson");

        TextView lessonText = (TextView) findViewById(R.id.lessonText);
        switch (lesson) {
            case 0:
                lessonText.setText("Addition");
                break;
            case 1:
                lessonText.setText("Subtraction");
                break;
            case 2:
                lessonText.setText("Multiplication");
                break;
            case 3:
                lessonText.setText("Division");
                break;
            default:
                break;
        }

        lessonButton = (Button) findViewById(R.id.lessonButton);
        gameButton  = (Button) findViewById(R.id.gameButton);
        fcButton = (Button) findViewById(R.id.fcButton);
        quizButton = (Button) findViewById(R.id.quizButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_math, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
