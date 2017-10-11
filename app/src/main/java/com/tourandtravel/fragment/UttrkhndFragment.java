package com.tourandtravel.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tourandtravel.R;

/**
 * Created by himanshu on 11-10-2017.
 */

public class UttrkhndFragment extends Fragment {

    public UttrkhndFragment(){


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_uttarakhand, parent, false);

/*
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view1);
*/
        setHasOptionsMenu(true);
   /*     ((AppCompatActivity) getActivity()).getSupportActionBar().hide();



*/









        return rootView;
    }




}
