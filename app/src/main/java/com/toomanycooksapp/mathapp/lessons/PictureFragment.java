package com.toomanycooksapp.mathapp.lessons;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toomanycooksapp.mathapp.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PictureFragment extends Fragment {

    public PictureFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_definition, container, false);
    }
}
