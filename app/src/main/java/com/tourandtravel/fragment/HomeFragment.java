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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by himanshu on 19-09-2017.
 */

public class HomeFragment extends BaseFragment {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private  FragmentManager fragmentManager;


    public HomeFragment(){


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.fragment_home, parent, false);

/*
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view1);
*/
        setHasOptionsMenu(true);
   /*     ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
*/


        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);






        return rootView;
    }

    @Override
    public void setTAG(String TAG) {

    }
    int count = 0;

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new ClusterFragment(),"Cluster");
        adapter.addFragment(new ActivitiesFragment(),"Activities");
        adapter.addFragment(new MapFragment(),"Map");
        adapter.addFragment(new NearByFragment(),"NearMe");
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }



}