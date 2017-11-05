package com.tourandtravel.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.extect.appbase.BaseFragment;
import com.tourandtravel.R;
import com.tourandtravel.adapter.ActivitiesAdapter;
import com.tourandtravel.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by himanshu on 18-09-2017.
 */

public class ActivitiesFragment  extends BaseFragment {


    private RecyclerView recyclerView;
    private List<Constant> cartList;
    private ActivitiesAdapter mAdapter;


    public static final String[] titles = new String[] { "jeep",
            "mountin", "trek", "yog"/*,"Chakrata","Kausani"," Chamoli","Dehradun","Dhanaulti","Haridwar",

    "HemkundShahib","Karanprayag"*/};

    public static final String[] descriptions = new String[] {
            "It is an aggregate accessory fruit",
            "It is the largest herbaceous flowering plant", "Citrus Fruit",
            "Mixed Fruits","kkkkkkkkkkkk",",,,,,,hhhhhhh","jjjjj","hhhhhhhhhhhhhhhhhhh","hhhhhhhhhhhh","gggggggg" };

    public static final Integer[] images = { R.drawable.jeep,
            R.drawable.mountion, R.drawable.trek, R.drawable.yog,R.drawable.chkrt,R.drawable.ksuni
            ,R.drawable.chmoli,R.drawable.dehrdun,R.drawable.dhnulti,R.drawable.hridwr,R.drawable.hemkund,};




    private FragmentManager fragmentManager;


    public  ActivitiesFragment(){


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_activities, parent, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view1);
        setHasOptionsMenu(true);

        cartList = new ArrayList<Constant>();
        for (int i = 0; i < titles.length; i++) {
            Constant item = new Constant(images[i], titles[i], descriptions[i]);
            cartList.add(item);
        }

       /* cartList = new ArrayList<>();*/

        mAdapter = new ActivitiesAdapter(getActivity(), cartList);




        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);
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

