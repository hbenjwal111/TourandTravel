package com.tourandtravel.activity;

/**
 * Created by himanshu on 08-09-2017.
 */

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.extect.appbase.BaseActivity;
import com.tourandtravel.R;
import com.tourandtravel.fragment.AboutFragment;
import com.tourandtravel.fragment.DashBoardFragment;
import com.tourandtravel.fragment.FeedFragment;
import com.tourandtravel.fragment.HomeFragment;
import com.tourandtravel.fragment.UttrkhndFragment;

import java.util.Stack;




public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener  {
    public static FragmentManager fragmentManager;
    CoordinatorLayout coordinatorLayout;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    private Stack<Fragment> fragmentStack;
    public DrawerLayout drawer;

    static Button notifCount;
    static int mNotifCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
/*
            getSupportActionBar().setLogo(R.drawable.notification_button);
*/
        }

        mFragmentManager = getSupportFragmentManager();
        // mFragmentTransaction = mFragmentManager.beginTransaction();
        //mFragmentTransaction.replace(R.id.fooFragment,new PersonalDetail()).commit();
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);




       /* navigationView.getMenu().setGroupVisible(R.id.employee, true);
        navigationView.getMenu().setGroupVisible(R.id.student, true);*/
        navigationView.setNavigationItemSelectedListener(this);




        View hView = navigationView.getHeaderView(0);



        DashBoardFragment homeFragment = new DashBoardFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.container, homeFragment);
        transaction.addToBackStack(null);

        transaction.commit();
        setTitle("Avaliable Tour");








    }







    @Override
    public void replaceView() {


    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

   if (id == R.id.nav_home) {
// Create fragment and give it an argument specifying the article it should show
           HomeFragment newFragment = new HomeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Personal Deatail");



            // Toast.makeText(getApplicationContext(),"home clicked",Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_uttr) {

            UttrkhndFragment newFragment = new UttrkhndFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Fee Detail");

            // Toast.makeText(getApplicationContext(),"Train Stations",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_about) {

            AboutFragment newFragment = new AboutFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Circular");
            // Toast.makeText(getApplicationContext(),"Train Schedule",Toast.LENGTH_LONG).show();
        }  else if (id == R.id.nav_feed) {


            FeedFragment newFragment = new FeedFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Library");



            //Toast.makeText(getApplicationContext(),"Profile",Toast.LENGTH_LONG).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }










    public void onBackPressed() {
        FragmentManager mgr = getSupportFragmentManager();
        if (mgr.getBackStackEntryCount() == 1) {
            // No backstack to pop, so calling super
            finish();
        } else {
            mgr.popBackStack();
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }





    }



