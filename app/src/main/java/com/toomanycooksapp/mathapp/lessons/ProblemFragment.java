package com.toomanycooksapp.mathapp.lessons;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.toomanycooksapp.mathapp.R;

import java.util.Random;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProblemFragment extends Fragment {

    private int subject;
    private int pass;

    private TextView questionRoot;
    private TextView questionSubject;
    private TextView questionTotal;
    private TextView questionPassed;
    private CheckBox a;
    private CheckBox b;
    private CheckBox c;
    private CheckBox d;

    public static boolean ANSWERSGIVEN[] = {false, false, false, false};
    public static boolean ANSWERKEYS[] = {false, false, false, false};


    public ProblemFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_problems, container, false);
        Bundle bundle = getArguments();
        subject = bundle.getInt("subject");
        pass = bundle.getInt("pass");

        questionRoot = (TextView) view.findViewById(R.id.problem_root);
        questionSubject = (TextView) view.findViewById(R.id.problems_subject);
        questionTotal = (TextView) view.findViewById(R.id.problem_total);
        questionPassed = (TextView) view.findViewById(R.id.pass);
        a = (CheckBox) view.findViewById(R.id.checkBox1);
        b = (CheckBox) view.findViewById(R.id.checkBox2);
        c = (CheckBox) view.findViewById(R.id.checkBox3);
        d = (CheckBox) view.findViewById(R.id.checkBox4);

        a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ANSWERSGIVEN[0] = isChecked;
            }
        });
        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ANSWERSGIVEN[1] = isChecked;
            }
        });
        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ANSWERSGIVEN[2] = isChecked;
            }
        });
        d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ANSWERSGIVEN[3] = isChecked;
            }
        });

        initQuestion(pass);

        return view;
    }

    public void initQuestion(int pass) {
        System.out.println("question inited");
        this.pass = pass;
        questionPassed.setText("" + (pass - 2));

        int total = 12;
        generateAnswerKey();
        a.setText(generateEquation(total, ANSWERKEYS[0]));
        b.setText(generateEquation(total, ANSWERKEYS[1]));
        c.setText(generateEquation(total, ANSWERKEYS[2]));
        d.setText(generateEquation(total, ANSWERKEYS[3]));



        a.setChecked(false);
        b.setChecked(false);
        c.setChecked(false);
        d.setChecked(false);


    }

    private void generateAnswerKey() {
        Random ran = new Random(System.currentTimeMillis());
        int c = 1 + ran.nextInt(3);
        int a = 0;
        int i =0;

        //try to do a quick random
        while(a < c){
            boolean answer = ran.nextBoolean();

            if(!ANSWERKEYS[i%4] && answer){
                ANSWERKEYS[i%4]=answer;
                a++;
            }

            i++;
            if(i>32){
                break;
            }
        }
        if(a == 0) ANSWERKEYS[ran.nextInt(4)] = true;
    }

    private String generateEquation(int answer, boolean correct) {
        Random ran = new Random(System.currentTimeMillis());
        String operand = subject == 0 ? "+" :
                subject == 2 ? "-" :
                        subject == 2 ? "*" : "/";
        int next = ran.nextInt();



        return "key = "+ correct;
    }
}
