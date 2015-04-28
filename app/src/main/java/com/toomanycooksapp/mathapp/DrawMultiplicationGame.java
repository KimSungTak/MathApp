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


    private int correct;
    private int fuel;
    private int part1;
    private int part2;
    private int[] answers = new int [4];
    private String equation;
    private Random r;
    private boolean guess = false;
    private boolean newQuestion = false;
    private boolean win = false;

    public DrawMultiplicationGame(Context context) {
        super(context);
    }


    private void makeEquation() {
        part1 = r.nextInt() % 15 + 1;
        part2 = r.nextInt() % 15 + 1;
        equation = part1 + "x" + part2;
    }

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

    private void updateFuel(){
        if(guess){
            fuel++;
        }
        else{
            fuel--;
        }
    }
    private boolean isGuess(int answer){
        if(answer == answers[answer]){
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


}
}
