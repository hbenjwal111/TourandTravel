package com.tourandtravel.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.extect.appbase.BaseFragment;
import com.tourandtravel.R;
import com.tourandtravel.activity.CommonBaseActivity;
import com.tourandtravel.adapter.TimeAdapter;
import com.tourandtravel.utils.room;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by himanshu on 01-11-2017.
 */

public class PrimeFragment  extends BaseFragment {


    private RecyclerView recyclerView;
    private List<room> roomList;
    private TimeAdapter mAdapter;

    public static final String[] time = new String[]{

            "may","jun","july","august","may","jun"
    };


    public static final String[] titles = new String[] {
            "Badrinath",
            "Gangotri", "Yamonotri", "Kedarnath",
            "Chakrata","Kausani"};

    public static final String[] type= new String[] {
           "ac","ac","ac","ac","ac","ac"

    };

    public static final String[] price = new String[]{

            "2000","2000","2000","2000","2000","2000"
    };

    public static final Integer[] images = {
            R.drawable.badinath,
            R.drawable.gangotri,
            R.drawable.yamunotri,
            R.drawable.kedarnath,

            R.drawable.chkrt,
            R.drawable.ksuni
            , R.drawable.chmoli,
            R.drawable.dehrdun,

            R.drawable.dhnulti,
            R.drawable.hridwr,
            R.drawable.hemkund,
            R.drawable.kedarnath};

    private FragmentManager fragmentManager;

    public PrimeFragment(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_prim, parent, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view1);
        setHasOptionsMenu(true);

        roomList = new ArrayList<room>();
        for (int i = 0; i < titles.length; i++) {
            room item = new room(images[i], titles[i], time[i],type[i],price[i]);
            roomList.add(item);
        }

       /* cartList = new ArrayList<>();*/

        mAdapter = new TimeAdapter(getActivity(), roomList);




        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);



        recyclerView.addOnItemTouchListener(new PrimeFragment.RecyclerTouchListener(getActivity(), recyclerView, new PrimeFragment.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent commonActivity = new Intent(getActivity(),CommonBaseActivity.class);
                commonActivity.putExtra("flowType", CommonBaseActivity.BOOK);
                startActivity(commonActivity);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);





            }

            @Override
            public void onLongClick(View view, int position) {

            }

        }));
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

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


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private PrimeFragment.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final PrimeFragment.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
