package com.toomanycooksapp.mathapp.lessons;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;

import com.toomanycooksapp.mathapp.R;

public class LessonsActivity extends ActionBarActivity implements View.OnClickListener {


    private PictureFragment pictureFragment;
    private DefinitionFragment definitionFragment;
    private ProblemFragment problemFragment;
    private FragmentManager manager;
    private int pass = 0;
    private  int subject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
        manager = this.getFragmentManager();
        subject = getIntent().getIntExtra("subject",0);


        Fragment fragment = Fragment.instantiate(this, DefinitionFragment.class.getName());
        Bundle b = new Bundle();
        b.putInt("pass", pass);
        b.putInt("subject", subject);
        fragment.setArguments(b);
        addFragment(fragment);

    }

    private void addFragment(Fragment fragment) {

        manager.executePendingTransactions();
        invalidateOptionsMenu();

        manager.beginTransaction()
                .replace(R.id.lesson_content, fragment)
                .commit();
    }


    //handle all transactions and events here
    
    @Override
    public void onClick(View v) {



    }
}
