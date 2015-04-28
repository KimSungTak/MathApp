package com.toomanycooksapp.mathapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
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
    TextView tv1;
    TextView sep1;
    TextView sep2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division_game);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        new AlertDialog.Builder(this)
                .setTitle("HOW TO PLAY")
                .setMessage("The goal of this game is to tap the correct answer to the question at the top of the screen before the answers reach the bottom of the screen.  If you run out of lives, you lose!")
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();

        //ag = new DrawDivisionGame(this);
        //setContentView(ag);
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
        TextView tv1 = (TextView)findViewById(R.id.textView2);
        tv1.setText("Hello");

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(50, 50, 0, 0);

        tv1.setLayoutParams(lp);
    }

    public void ButtonStart(View v)
    {
        tv1 = (TextView)findViewById(R.id.textView2);
        sep1 = (TextView)findViewById(R.id.textView6);
        sep2 = (TextView)findViewById(R.id.textView7);
        locY= tv1.getY();

        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                locY= tv1.getY();
                if(locY+tv1.getHeight() >= sep2.getY())
                    tv1.setY(sep1.getY()+1 +2*tv1.getHeight());
                else
                    tv1.setY(locY +50);
            }

        }, 0, 500);


    }
}
