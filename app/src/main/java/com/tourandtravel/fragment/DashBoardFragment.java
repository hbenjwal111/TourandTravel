package com.tourandtravel.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tourandtravel.R;
import com.tourandtravel.adapter.DashBoardAdapter;

import java.util.Timer;

/**
 * Created by himanshu on 4/15/2017.
 */



public class DashBoardFragment extends Fragment {






    private Context mContext;

    private ImageView imageView;


    RelativeLayout mRelativeLayout;
    private RecyclerView mRecyclerView;



    // private RecyclerView nRecyclerView;

    private RecyclerView.LayoutManager nLayoutManager;

    private RecyclerView.Adapter mAdapter;
    //  private RecyclerView.Adapter nAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private GridLayoutManager gridLayoutManagerVertical;
    private GridLayoutManager gridLayoutManagerHorizontal;

    private ViewPager viewPager;

    int currentPage = 0;

    int NUM_PAGES = 3;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.


    public DashBoardFragment() {


    }




    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_dashboard, parent, false);

/*
        List<Nature> getData = dataSource();
*/
      /*  viewPager = (ViewPager)rootView.findViewById(R.id.viewpager);
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
*/




       /* mRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.rl);*/
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        // mRecyclerView =(RecyclerView)findViewById(R.id.recycler_view1);
        // nRecyclerView =(RecyclerView) findViewById(R.id.images2);

        // Initialize a new String array
        String[] animals = {
                "Individual",
                "Educational ",
                "Corporate ",
                "Leisure ",
                "Wellness ",




        };





        /*
            GridLayoutManager
                A RecyclerView.LayoutManager implementations that lays out items in a grid.
                By default, each item occupies 1 span. You can change it by providing a custom
                GridLayoutManager.SpanSizeLookup instance via setSpanSizeLookup(SpanSizeLookup).
        */
        /*
            public GridLayoutManager (Context context, int spanCount)
                Creates a vertical GridLayoutManager

            Parameters
                context : Current context, will be used to access resources.
                spanCount : The number of columns in the grid
        */
        // Define a layout for RecyclerView
        GridLayoutManager mLayoutManager = new GridLayoutManager(mContext, 2);

        //  final GridLayoutManager nLayoutManager =new GridLayoutManager(mContext,1);


        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            // nLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup())
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {

                    return 1;
                } else if (position == 1) {

                    return 1;
                } else if (position == 2) {

                    return 1;
                } else if (position == 3) {

                    return 1;
                } else if (position == 4) {

                    return 1;
                } else if (position == 5) {
                    return 1;

                } else
                {
                    return 2;
                }






            }
        });


        mRecyclerView.setLayoutManager(mLayoutManager);
        //nRecyclerView.setLayoutManager(nLayoutManager);


        // Initialize a new instance of RecyclerView Adapter instance
        mAdapter = new DashBoardAdapter(getActivity(), animals);
        // mAdapter = new AnimalsAdapter(mContext,listviewImage);
        // mAdapter = new AnimalsAdapter(mContext,images);
        //nAdapter =new AnimalsAdapter(mContext,images);


        // Set the adapter for RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        //nRecyclerView.setAdapter(nAdapter);


        return rootView;


    }



   /* private List<Nature> dataSource() {
        List<Nature> data = new ArrayList<Nature>();
        data.add(new Nature(R.drawable.schh ));
        data.add(new Nature(R.drawable.school));
        data.add(new Nature(R.drawable.college));


        return data;
    }*/
}