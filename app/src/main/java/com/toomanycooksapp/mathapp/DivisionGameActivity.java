package com.toomanycooksapp.mathapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

/**
 * Created by Charlie on 4/23/2015.
 * Activity that runs the division game
 */
public class DivisionGameActivity extends ActionBarActivity {

    //DrawDivisionGame ag = null;
    float locY;

    TextView score;

    TextView problem;

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;

    TextView sep1;
    TextView sep2;

    Button start;

    Timer myTimer;

    boolean lock=false;

    private int answer;                         //the correct answer to the generated question
    private String problemString;               //string value of the division problem
    private int[] answerTiles = new int[4];     //the answer tiles that fall from the top of the screen
    // notifies the program if it needs to generate a new answer
    private int lives = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division_game);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        new AlertDialog.Builder(this)
                .setTitle("HOW TO PLAY")
                .setMessage("The goal of this game is to tap the correct answer to the question at the top of the screen before the answers reach the bottom of the screen.")
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();

        problem = (TextView) findViewById(R.id.textView6);

        tv1 = (TextView)findViewById(R.id.textView2);
        tv2 = (TextView)findViewById(R.id.textView3);
        tv3 = (TextView)findViewById(R.id.textView4);
        tv4 = (TextView)findViewById(R.id.textView5);

        sep1 = (TextView)findViewById(R.id.textView6);
        sep2 = (TextView)findViewById(R.id.textView7);

        score = (TextView) findViewById(R.id.textView8);

        locY= tv1.getY();

        start = (Button)findViewById(R.id.button);
        tv1.setEnabled(false);
        tv2.setEnabled(false);
        tv3.setEnabled(false);
        tv4.setEnabled(false);

       changeText();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_game, menu);
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

    public void PrintHi(View v)
    {
        if(lock == false){
        if(tv1.getText().equals(Integer.toString(answer)))
        {
            tv1.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            tv2.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            tv3.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            tv4.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            changeText();

            score.setText(Integer.toString(Integer.parseInt(score.getText().toString())+1));
        }

        else
        {
            tv1.setTextColor(Color.RED);
        }
    }}

    public void Answer2(View v)
    {
        if(lock==false){
        if(tv2.getText().equals(Integer.toString(answer)))
        {
            tv1.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            tv2.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            tv3.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            tv4.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            changeText();
            score.setText(Integer.toString(Integer.parseInt(score.getText().toString())+1));
        }
        else
        {
            tv2.setTextColor(Color.RED);
        }
    }}

    public void Answer3(View v)
    {
        if(lock ==false){
        if(tv3.getText().equals(Integer.toString(answer)))
        {
            tv1.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            tv2.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            tv3.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            tv4.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            changeText();
            score.setText(Integer.toString(Integer.parseInt(score.getText().toString())+1));
        }

        else
        {
            tv3.setTextColor(Color.RED);
        }
    }}

    public void Answer4(View v)
    {
        if(lock == false){
        if(tv4.getText().equals(Integer.toString(answer)))
        {
            tv1.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            tv2.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            tv3.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            tv4.setY(sep1.getY() + 2 * tv1.getHeight() - 20);
            changeText();
            score.setText(Integer.toString(Integer.parseInt(score.getText().toString())+1));
        }
        else
        {
            tv4.setTextColor(Color.RED);
        }}
    }

    public void ButtonStart(View v)
    {
        tv1.setEnabled(true);
        tv2.setEnabled(true);
        tv3.setEnabled(true);
        tv4.setEnabled(true);
        start.setEnabled(false);

        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                locY= tv1.getY();
                if(locY+tv1.getHeight() >= sep2.getY()) {
                    myTimer.cancel();
                    lock = true;
                }
                else {
                    tv1.setY(locY + 5);
                    tv2.setY(locY + 5);
                    tv3.setY(locY + 5);
                    tv4.setY(locY + 5);
                }
            }

        }, 30, 30);
    }

    private void createProblem(){
        int numerator, denominator;     // numerator/denominator
        double tempAnswer;              //temporary answer for integer logic

        //initialize random number generator
        Random r = new Random();

        //generate a numerator always above 2
        numerator = r.nextInt(20 - 2 + 1) + 2;

        //keep generating a denominator that is less than the numerator until you get an integer answer
        //between 1 and numerator
        while(true){
            denominator = r.nextInt(numerator - 1 + 1) + 1;

            tempAnswer = (double)numerator/(double)denominator;

            //see if the answer is an integer
            if (tempAnswer == (int)tempAnswer){
                //if it is, set the answer and break the loop
                answer = numerator/denominator;
                break;
            }
        }

        //put the problem into string form
        problemString = numerator + " / " + denominator + " = ?"/*+ answer*/;

        //put the answer in the answer tiles randomly
        int answerIndex = r.nextInt(answerTiles.length);
        answerTiles[answerIndex] = answer;

        //fill in the rest with dummy values
        for(int i=0;i<answerTiles.length;i++){
            //if we aren't on the correct answer
            if(i!=answerIndex){
                while(true){
                    //try a random number
                    int tryAnswer = r.nextInt(20 - 1 + 1) + 1;
                    //if that number isn't in the answer tiles
                    if(!answerIsInTiles(tryAnswer)){
                        //add it and break the loop
                        answerTiles[i] = tryAnswer;
                        break;
                    }
                    //otherwise keep looping
                }
            }
        }
    }

    private boolean answerIsInTiles(int look){
        for(int i=0; i<answerTiles.length; i++){
            if(answerTiles[i]==look){
                return true;
            }
        }
        return false;
    }

    private void changeText()
    {
        createProblem();

        tv1.setText(Integer.toString(answerTiles[0]));
        tv1.setTextColor(Color.BLACK);
        tv2.setText(Integer.toString(answerTiles[1]));
        tv2.setTextColor(Color.BLACK);
        tv3.setText(Integer.toString(answerTiles[2]));
        tv3.setTextColor(Color.BLACK);
        tv4.setText(Integer.toString(answerTiles[3]));
        tv4.setTextColor(Color.BLACK);

        problem.setText(problemString);
    }
}


