package com.toomanycooksapp.mathapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

/**
 * Created by david on 2/18/15.
 * Creates view for the addition game
 */
public class DrawAddGame extends View{

    int[] fills = new int[49];

    public DrawAddGame(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        fills[30] = 9;

        int squareSize = canvas.getWidth() / 9;
        Log.d("check nulls", "Square Size: " + squareSize);
        Log.d("check nulls", "Canvas Width: " + canvas.getWidth());
        Log.d("check nulls", "Canvas Height: " + canvas.getHeight());
        int x = squareSize;
        int y = canvas.getHeight() - (9 * squareSize);
        int xEnd = canvas.getWidth() - squareSize - 1;

        Rect[] squares = new Rect[49];
        for(int i = 0; i < squares.length; i++) {
            squares[i] = new Rect();
            squares[i].set(x,y,(x + squareSize), (y + squareSize));

            Paint borderBlue = new Paint();
            borderBlue.setColor(Color.BLUE);
            borderBlue.setStyle(Paint.Style.STROKE);

            Paint fillBlueText = new Paint();
            fillBlueText.setColor(Color.BLUE);
            fillBlueText.setStyle(Paint.Style.FILL);
            fillBlueText.setTextSize(100);

            canvas.drawRect(squares[i], borderBlue);
            if(fills[i] != 0) {
                canvas.drawText(String.valueOf(fills[i]), (x + (squareSize / 4)), (y + squareSize - 20), fillBlueText);
            }

            x += squareSize;
            if(x >= xEnd) {
                x = squareSize;
                y += squareSize;
            }
        }
    }
}
