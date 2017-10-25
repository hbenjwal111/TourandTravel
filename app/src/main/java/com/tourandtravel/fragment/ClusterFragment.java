package com.tourandtravel.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import com.tourandtravel.R;
import com.tourandtravel.adapter.ClusterAdapter;
import com.tourandtravel.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by himanshu on 18-09-2017.
 */

public class ClusterFragment extends Fragment {


    private RecyclerView recyclerView;
    private List<Constant> cartList;
    private ClusterAdapter mAdapter;


    public static final String[] titles = new String[] {
            "Badrinath",
            "Gangotri", "Yamonotri", "Kedarnath",
            "Chakrata","Kausani"," Chamoli",
            "Dehradun","Dhanaulti","Haridwar",

            "HemkundShahib","Karanprayag"};

    public static final String[] descriptions = new String[] {
            "It is an aggregate accessory fruit",
            "It is the largest herbaceous flowering plant",
            "Citrus Fruit",
            "It is an aggregate accessory fruit",

            "It is the largest herbaceous flowering plant",
            "Citrus Fruit",
            "It is an aggregate accessory fruit",
            "It is an aggregate accessory fruit",

            "It is the largest herbaceous flowering plant",
            "Citrus Fruit",
            "It is an aggregate accessory fruit",
            "It is the largest herbaceous flowering plant"

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

    public ClusterFragment(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_cluster, parent, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view1);
        setHasOptionsMenu(true);

        cartList = new ArrayList<Constant>();
        for (int i = 0; i < titles.length; i++) {
            Constant item = new Constant(images[i], titles[i], descriptions[i]);
            cartList.add(item);
        }

       /* cartList = new ArrayList<>();*/

        mAdapter = new ClusterAdapter(getActivity(), cartList);




        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new DashBoardFragment.RecyclerTouchListener(getActivity(), recyclerView, new DashBoardFragment.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                // SelectedPosition = position;
                // HomeFragment myFragment = new HomeFragment();

                //Create a bundle to pass data, add data, set the bundle to your fragment and:
                // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();

                /*Intent commonActivity = new Intent(getActivity(),CommonBaseActivity.class);
                commonActivity.putExtra("flowType", CommonBaseActivity.CLUSTER);
                startActivity(commonActivity);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);*/
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return rootView;
    }


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private DashBoardFragment.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final DashBoardFragment.ClickListener clickListener) {
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
