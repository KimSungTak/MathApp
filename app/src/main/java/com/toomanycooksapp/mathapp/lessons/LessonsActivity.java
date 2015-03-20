package com.toomanycooksapp.mathapp.lessons;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.PopupMenu;

import com.toomanycooksapp.mathapp.R;

public class LessonsActivity extends ActionBarActivity implements View.OnClickListener {


    private PictureFragment pictureFragment;
    private DefinitionFragment definitionFragment;
    private ProblemFragment problemFragment;
    private FragmentManager manager;
    private int pass = 0;
    private int subject;
    public static final String[] SUBJECTS = {"ADD","SUBTRACT","MULTIPLY", "DIVIDE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
        manager = this.getFragmentManager();
        subject = getIntent().getIntExtra("subject", 0);

        addFragment(DefinitionFragment.class.getName());

    }

    private void addFragment(String name) {

        Fragment fragment = Fragment.instantiate(this, name);
        Bundle b = new Bundle();
        b.putInt("pass", pass);
        b.putInt("subject", subject);
        fragment.setArguments(b);
        manager.executePendingTransactions();
        invalidateOptionsMenu();

        manager.beginTransaction()
                .replace(R.id.lesson_content, fragment)
                .commit();
    }


    //handle all transactions and events here

    @Override
    public void onClick(View v) {
        switch (pass) {
            case 0:
                onDefinitionClicks(v);
                break;
        }


    }

    private void onDefinitionClicks(View v) {

        int id = v.getId();
        int pressed = -1;
        switch (id) {
            case R.id.define_increase:
                pressed = 0;
                break;
            case R.id.define_repeat:
                pressed = 2;
                break;
            case R.id.define_seperate:
                pressed = 3;
                break;
            case R.id.define_take:
                pressed = 1;
                break;
        }
        final boolean passed = subject == pressed;
        //pop ups
        AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
        alert.setMessage("To "+SUBJECTS[pressed]+" means to "+DefinitionFragment.DEFINITIONS[pressed] + ".");
        alert.setTitle(passed?"Great Job!":"Not Quite");
        alert.setPositiveButton(passed?"Onward!":"Try Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (passed) {
                    pass++;
                    addFragment(PictureFragment.class.getName());
                } else {
                    //do nothing
                }
            }

        });
        AlertDialog popup = alert.create();
        popup.show();

    }
}
