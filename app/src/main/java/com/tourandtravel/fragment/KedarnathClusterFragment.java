package com.tourandtravel.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tourandtravel.R;

/**
 * Created by himanshu on 19-09-2017.
 */

public class KedarnathClusterFragment extends Fragment {

    private Toolbar toolbar;


    private FragmentManager fragmentManager;


    public KedarnathClusterFragment() {


    }


    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_kedarnath, parent, false);


        setHasOptionsMenu(true);


        return rootView;


    }

}