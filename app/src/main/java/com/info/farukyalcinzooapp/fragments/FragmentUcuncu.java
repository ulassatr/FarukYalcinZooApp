package com.info.farukyalcinzooapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.info.farukyalcinzooapp.R;

/**
 * Created by kasimadalan on 9.01.2017.
 */

public class FragmentUcuncu extends Fragment {

    public FragmentUcuncu() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ucuncu_layout, container, false);
    }

}
