package com.toomanycooksapp.mathapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Charlie Milius on 4/23/2015.
 * Creates view and runs the division game
 */
public class DrawDivisionGame extends View {

    //variables
    private int[] dropGrid = new int[49];       //grid of spaces where answers will fall from
    private boolean changed = false;
    private boolean isUpdating = false;
    private int goal;
    private int numToDrop;
    private int squareSize;
    private boolean gameOver = false;
    private int score = 0;
    private int[] dropQueue = new int[3];
    private boolean newGame = true;


    //default constructor
    public DrawDivisionGame(Context context) {
        super(context);
    }






















}
