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
        getActivity().setTitle("Where You Want To Go");




       /* rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i("key code", "keyCode: " + keyCode);
                showToast("back pressed...");
                if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    if(count!=0) {
                        Log.i("key code", "onKey Back listener is working!!!");
                        FragmentManager fm = getFragmentManager();
                        if (fm.getBackStackEntryCount() > 0) {
                            //fm.popBackStack();
                            getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                        } else {
                            getActivity().onBackPressed();
                        }
                        getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

                       *//* getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        getActivity().finish();*//*
                    *//*DashBoardFragment homeFragment = new DashBoardFragment();
                    FragmentTransaction transaction = getBaseActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, homeFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();*//*
                    }
                    else
                    {
                        count++;
                    }
                    return true;
                }
                return false;
            }
        });*/

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
    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        return false;
    }*/


   /* @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (menu.findItem(R.id.miCompose) != null) {
            menu.findItem(R.id.miCompose).setVisible(false);
        }


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Toast.makeText(getActivity(), "called " + item.getItemId(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case android.R.id.home:
                FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    //fm.popBackStack();
                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                } else {
                    getActivity().onBackPressed();
                }
                getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

                break;
           *//* case R.id.miCompose:

                AddDuaFragment fragobj = new AddDuaFragment();
                Bundle bundle = new Bundle();
                bundle.putString("duaData", "");
                bundle.putInt("duaId",0);
                fragobj.setArguments(bundle);
                getBaseActivity().replaceView(R.id.fullscreen_content_controls, fragobj, true, false);



                break;*//*

        }
        return super.onOptionsItemSelected(item);
    }*/


}
