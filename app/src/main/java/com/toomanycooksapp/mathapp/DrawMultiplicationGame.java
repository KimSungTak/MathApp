package com.toomanycooksapp.mathapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;
import java.util.Stack;
import java.lang.String;
/**
 * Created by Daniel on 4/23/2015.
 */
public class DrawMultiplicationGame extends View{


    private int correct; //stores the correctly generated answer to question
    private int fuel; //meter that changes depending on correct/incorrect answer
    private int part1;//first value of generated question
    private int part2;//second value of generated question
    private int[] answers = new int [4];//stores the correct answer along with generated answers
    private String equation;//stores the generated question into a string
    private Random r;//passed around to generate values for questions and answers
    private boolean guess = false;//value changes depending on pressing right answer
    private boolean newQuestion = false;//checks to generate new question
    private boolean win = false;//checks to see if player won the game
    private int canvasHeight;
    private int canvasWidth;

    public DrawMultiplicationGame(Context context) {
        super(context);
    }

    /**
     * generates new multiplication equation into a string
     */
    private void makeEquation() {
        part1 = r.nextInt() % 15 + 1;
        part2 = r.nextInt() % 15 + 1;
        equation = part1 + "x" + part2;
    }

    /**
     * randomly stores the correct answer into the answers[] array along with generated values for the remaining slots
     */
    private void makeAnswers(){
        int x, i;
        correct = part1*part2;
        x = r.nextInt()%4;
        answers[x] = correct;
        for(i = 0; i < 4; i++){
            if(answers[i] == 0){
               answers[i] = correct+ r.nextInt()%20 - 10;
            }

        }
    }

    /**
     * correct guess increases fuel value while incorrect guess decreases fuel
     */
    private void updateFuel(){
        if(guess){
            fuel++;
        }
        else{
            fuel--;
        }
    }

    /**
     * checks whether answer in answers[] contains the correct answer
     * @param answer contains either one of 4 integer value "0-3"
     * @return
     */
    private boolean isGuess(int answer){
        int i = 0;
        while(i < 4){
            if(answers[i] == correct){
                break;
            }
            i++;
        }

        if(answer == i){
            guess = true;
            newQuestion = true;
        }
        else{
            guess = false;
            newQuestion = false;
        }
        return guess;
    }
    private int getFuel(){
        return fuel;
    }
    private String getQuestion(){
        return equation;
    }

    private int[] getAnswers(){
        return answers;
    }

    /**
     * if fuel reaches 10+, the player wins
     * @return boolean win
     */
    private boolean isWin(){
        if(fuel >= 10){
            win = true;
        }
        else{
            win = false;
        }
        return win;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(newQuestion) {
            makeEquation();
            makeAnswers();
            newQuestion = false;
        }

        Paint borderBlue = new Paint();
        borderBlue.setColor(Color.BLUE);
        canvasHeight = canvas.getHeight();
        canvasWidth = canvas.getWidth();
        canvas.drawRect(canvasWidth-15, canvasHeight - (getFuel()%10), canvasWidth, canvasHeight, borderBlue);
}
}
