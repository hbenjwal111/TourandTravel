package com.tourandtravel.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.extect.appbase.BaseFragment;
import com.tourandtravel.R;

/**
 * Created by himanshu on 01-11-2017.
 */

public class RoomTypeFragment extends BaseFragment {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentManager fragmentManager;

    String hotel_id;


    public RoomTypeFragment(){


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_home, parent, false);

        hotel_id = getActivity().getIntent().getExtras().getString("hotel_id");


/*
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view1);
*/
        setHasOptionsMenu(true);
   /*     ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

*/




        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);

        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);


        viewPager.setAdapter(new ViewPagerAdapter(getFragmentManager()));

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);







        return rootView;
    }



    public class ViewPagerAdapter extends FragmentPagerAdapter {

        String[] title = new String[]{
                "Prime Time", "Leisure Time"
        };

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }



        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new PrimeFragment();

                    break;
                case 1:
                    fragment = new LeisureFragment();
                    break;

                default:
                    fragment = null;
                    break;
            }
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public int getCount() {
            return title.length;
        }







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


