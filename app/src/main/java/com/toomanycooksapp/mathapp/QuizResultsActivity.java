package com.toomanycooksapp.mathapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class QuizResultsActivity extends ActionBarActivity {

    QuizSingleton quiz;
    int lesson;
    String lessonName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent calledBy = getIntent();
        lesson = calledBy.getExtras().getInt("lesson");
        switch(lesson)
        {
            //0 -> Addition
            case 0:
                lessonName = "addition";
                break;
            default:
                return;
        }

        quiz = QuizSingleton.getInstance();

        TextView resultsMessage = (TextView) findViewById(R.id.resultsMessage);
        resultsMessage.setText("You answered " + quiz.getNumberCorrect() + " questions correctly out of " + quiz.getNumberOfQuestions() + "!");

        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHomeScreen();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz_results, menu);
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

    //Returns to MainActivity, deleting itself on exit
    public void goToHomeScreen()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
