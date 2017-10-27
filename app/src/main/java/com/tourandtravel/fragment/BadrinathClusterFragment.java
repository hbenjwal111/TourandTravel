package com.tourandtravel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.extect.appbase.BaseFragment;
import com.tourandtravel.R;
import com.tourandtravel.activity.HotelActivity;


/**
 * Created by himanshu on 19-09-2017.
 */


public class BadrinathClusterFragment extends BaseFragment {

    private Toolbar toolbar;


    private FragmentManager fragmentManager;

    private Button mButton;


    public BadrinathClusterFragment() {


    }


    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_badrinath, parent, false);

        mButton = (Button) rootView.findViewById(R.id.button_previous);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent openPayUMobilePayment = new Intent(getActivity(),HotelActivity.class);
                startActivity(openPayUMobilePayment);

            }
        });


        setHasOptionsMenu(true);

        return rootView;



    }

    @Override
    public void setTAG(String TAG) {

    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

    }
}


















