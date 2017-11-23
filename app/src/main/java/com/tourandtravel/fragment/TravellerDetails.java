package com.tourandtravel.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.extect.appbase.BaseFragment;
import com.tourandtravel.R;
import com.tourandtravel.api.APIService;
import com.tourandtravel.payumobile.PayUMainActivity;

/**
 * Created by himanshu on 02-11-2017.
 */

public class TravellerDetails extends BaseFragment {

    private APIService mAPIService;
    private TextInputLayout nameTitle, emailTitle, phoneTitle;
    private EditText nameEdt, emailEdt,  phoneEdt;

    private ProgressDialog progressDialog;


    private TextView mContinue;

    public TravellerDetails(){



    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_traveller, parent, false);

        mContinue = (TextView)rootView.findViewById(R.id.choose);

        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent commonActivity = new Intent(getActivity(),PayUMainActivity.class);
                startActivity(commonActivity);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

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
