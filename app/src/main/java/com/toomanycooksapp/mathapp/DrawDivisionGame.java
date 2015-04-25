package com.toomanycooksapp.mathapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by Charlie Milius on 4/23/2015.
 * Creates view and runs the division game
 */
public class DrawDivisionGame extends View {

    private int answer;                         //the correct answer to the generated question
    private String problemString;               //string value of the division problem
    private int[] answerTiles = new int[5];     //the answer tiles that fall from the top of the screen
    private boolean newAnswer = true;           //notifies the program if it needs to generate a new answer
    private int lives = 5;
    private int[] tiles = new int[5];
    private int canvasHeight;
    private int canvasWidth;


    //default constructor
    public DrawDivisionGame(Context context) {
        super(context);
    }

    //creates a random division problem using numbers between 1 and 20
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

    //looks to see if the answer is already in the tiles
    private boolean answerIsInTiles(int look){
        for(int i=0; i<answerTiles.length; i++){
            if(answerTiles[i]==look){
                return true;
            }
        }
        return false;
    }

    @Override
    //draws the game on the canvas
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //if you need a new answer, reset some things
        if(newAnswer){
            createProblem();
            newAnswer = false;
        }

        //probably don't need these...
        canvasHeight = canvas.getHeight();
        canvasWidth = canvas.getWidth();

        //declare the color objects
        Paint borderBlue = new Paint();
        borderBlue.setColor(Color.BLUE);
        borderBlue.setStyle(Paint.Style.STROKE);

        Paint fillMagentaText = new Paint();
        fillMagentaText.setColor(Color.MAGENTA);
        fillMagentaText.setStyle(Paint.Style.FILL);
        fillMagentaText.setTextSize(80);

        Paint fillGreenText = new Paint();
        fillGreenText.setColor(Color.parseColor("#19BF19"));
        fillGreenText.setStyle(Paint.Style.FILL);
        fillGreenText.setTextSize(80);

        Paint fillRedText = new Paint();
        fillRedText.setColor(Color.RED);
        fillRedText.setStyle(Paint.Style.FILL);
        fillRedText.setTextSize(80);

        //draw the problem
        canvas.drawText(String.valueOf(problemString), (canvas.getWidth() / 10), (canvas.getHeight() / 12), fillGreenText);

        //draw all of the answers
        for(int i = 0; i < answerTiles.length; i++) {
            canvas.drawText(String.valueOf(answerTiles[i]), (canvas.getWidth() / answerTiles.length) * (i), (canvas.getHeight() / 12)*2, fillMagentaText);
        }

        //draw how many lives you have left
        canvas.drawText("LIVES: " + String.valueOf(lives), (canvas.getWidth() / 10), (canvas.getHeight()/15)*14, fillGreenText);

        //reposition the answers every second(falling)  THIS IS WHERE I LEFT OFF
        /*for(int j=3;j<((canvas.getHeight()/12)*8);j++) {
            canvas.restore();
            for(int i = 0; i < answerTiles.length; i++) {
                canvas.drawText(String.valueOf(answerTiles[i]), (canvas.getWidth() / answerTiles.length) * (i), (canvas.getHeight() / 12) * j, fillMagentaText);
            }
        }*/

        /*
        //if the correct answer was chosen, draw it to the screen
        if(checkCorrect < goal) {
            canvas.drawText("INCORRECT", (canvas.getWidth() / 2) - 225, (canvas.getHeight() / 2) - 200, fillRedText);
            canvas.drawText("GAME OVER", (canvas.getWidth() / 2) - 225, (canvas.getHeight() / 2) + 200, fillRedText);
        }*/
    }

    @Override
    //this is there touch event, not quite sure how it works yet
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Touched: ", "Has been touched");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Up Touch: ", "Up touched");
                float tapXSpace = event.getX();
                float tapYSpace = event.getY();

                if(tapYSpace <= ((canvasHeight / 2) + 100) && tapYSpace >= ((canvasHeight / 2) - 100)) {
                    for(int i = 0; i < 5; i++) {
                        if(tapXSpace > ((canvasWidth / 6) * (i + 1) - 100) && tapXSpace < ((canvasWidth / 6) * (i + 1) + 100)) {
                            tiles[i] = 0;
                        }
                    }
                    invalidate();
                    return true;
                }
            default:
                Log.d("Is here at least: ", String.valueOf(event.getAction()));
                return super.onTouchEvent(event);

        }
    }



















}
