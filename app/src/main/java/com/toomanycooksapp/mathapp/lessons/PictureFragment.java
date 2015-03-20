package com.toomanycooksapp.mathapp.lessons;

import android.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.toomanycooksapp.mathapp.R;

import java.util.Random;

/**
 * A placeholder fragment containing a simple view.
 */
public class PictureFragment extends Fragment {

    private int subject;
    private int pass;
    private LinearLayout top;
    private LinearLayout bottom;
    private View vthis;
    private final static Random RANDOM = new Random(System.currentTimeMillis());
    public static final int NUMBERS[][] = {
            /*ADD**/{1,2,3,4,5},
            /*SUB**/{1,2,3,4,5,6,7,8},
            /*MULT*/{2,3,4},
            /*DIV**/{2,3,4,6,8}
    };
    public static int answer = -1;

    public PictureFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vthis =inflater.inflate(R.layout.fragment_picture, container, false);
        top = (LinearLayout) vthis.findViewById(R.id.picture_x_layout);
        bottom = (LinearLayout) vthis.findViewById(R.id.picture_y_layout);
        Bundle b = getArguments();
        subject = b.getInt("subject");
        pass = b.getInt("pass");
        switch (subject){
            case 0:
                add();
                break;
            case 1:
                sub();
                break;

            case 2:
                mult();
                break;
            case 3:
                div();
                break;

        }


        return vthis;
    }

    private void add() {
        int x = NUMBERS[subject][RANDOM.nextInt(NUMBERS[subject].length -1)];
        int y = NUMBERS[subject][RANDOM.nextInt(NUMBERS[subject].length -1)];
        ((TextView)vthis.findViewById(R.id.picture_x)).setText(""+x);
        ((TextView)vthis.findViewById(R.id.picture_y)).setText(""+y);

        for(int i = 0; i< x; i++){
            ImageView square = new ImageView(getActivity());
            square.setPadding(5,5,5,5);
            square.setImageResource(R.drawable.square_green);
            top.addView(square);
        }
        for(int i = 0; i< y; i++){
            ImageView square = new ImageView(getActivity());
            square.setPadding(5,5,5,5);

            square.setImageResource(R.drawable.square_green);
            bottom.addView(square);
        }

        answer = x + y;


    }
    private void sub() {

    }
    private void div() {

    }
    private void mult() {

    }

}
