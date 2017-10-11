package com.tourandtravel.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tourandtravel.R;
import com.tourandtravel.adapter.CustomPageAdapter;
import com.tourandtravel.adapter.DashBoardAdapter;
import com.tourandtravel.utils.ItemList;
import com.tourandtravel.utils.Nature;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by himanshu on 4/15/2017.
 */



public class DashBoardFragment extends Fragment {


    private RecyclerView recyclerView;
    private List<ItemList> listItem;
    private DashBoardAdapter mAdapter;

    private ViewPager viewPager;
    public Context mContext;


    int currentPage = 0;

    int NUM_PAGES = 4;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.





    public static final Integer[] images = { R.drawable.edu,
            R.drawable.corp, R.drawable.leis, R.drawable.well};




    private FragmentManager fragmentManager;


    public DashBoardFragment(){


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_dashboard, parent, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view1);
        setHasOptionsMenu(true);

        List<Nature> getData = dataSource();
        viewPager = (ViewPager)rootView.findViewById(R.id.viewpager);
        CustomPageAdapter mCustomPagerAdapter = new CustomPageAdapter(getActivity(), getData);
        viewPager.setAdapter(mCustomPagerAdapter);
        CircleIndicator indicator = (CircleIndicator) rootView.findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {

                if (currentPage == NUM_PAGES+1) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 500, 3000);




        listItem = new ArrayList<ItemList>();
        for (int i = 0; i < images.length; i++) {
            ItemList item = new ItemList(images[i]);
            listItem.add(item);
        }

       /* cartList = new ArrayList<>();*/

        mAdapter = new DashBoardAdapter(getActivity(), listItem);




        GridLayoutManager mLayoutManager = new GridLayoutManager(mContext, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);


        return rootView;
    }


    private List<Nature> dataSource() {
        List<Nature> data = new ArrayList<Nature>();
        data.add(new Nature(R.drawable.dhnulti ));
        data.add(new Nature(R.drawable.chmoli));
        data.add(new Nature(R.drawable.uttrkshi));

        data.add(new Nature(R.drawable.chkrt));


        return data;
    }


}
