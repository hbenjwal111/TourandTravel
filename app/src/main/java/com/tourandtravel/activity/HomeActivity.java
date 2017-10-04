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
import com.tourandtravel.fragment.DashBoardFragment;

import java.util.Stack;

/*
import org.education.Fragment.Attendence;
import org.education.Fragment.AttendenceFragment;
import org.education.Fragment.Book;
import org.education.Fragment.Circular;

import org.education.Fragment.FeeDetail;
import org.education.Fragment.LeaveFragment;
import org.education.Fragment.Library;
import org.education.Fragment.NoticeBoard;
import org.education.Fragment.PersonalDetail;
import org.education.Fragment.PersonalProfile;
import org.education.Fragment.ReportCardFragment;
import org.education.Fragment.SalaryFragment;
import org.education.Fragment.TimeTable;
import org.education.R;

import com.extect.appbase.BaseActivity;
import com.splunk.mint.Mint;
*/


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


        //    fragmentStack = new Stack<Fragment>();
        // String stu_code = getIntent().getExtras().getString("stu_code");
        //  Toast.makeText(this,"hello"+stu_code,Toast.LENGTH_SHORT).show();

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
        // BaseFlyContext.getInstant().setActivity(this);
        //  SettingServices.init(getApplicationContext());

        // initialising the object of the FragmentManager. Here I'm passing getSupportFragmentManager().
        // You can pass getFragmentManager() if you are coding for Android 3.0 or above.
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

      /*  navigationView.getMenu().removeItem(R.id.nav_attendence);
        navigationView.getMenu().add(R.id.nav_book);*/

      /*  navigationView.getMenu().removeItem(R.id.nav_msg);
        navigationView.getMenu().add(R.id.nav_msg);*/


        View hView = navigationView.getHeaderView(0);

       /* tvLoggedInName = (TextView) hView.findViewById(R.id.loggedInUserName);

          ivAvatarImage = (NetworkImageView) hView.findViewById(R.id.avatarNetworkImageView);
      */


        // Create fragment and give it an argument specifying the article it should show
       /* DashBoardFragment homeFragment = new DashBoardFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.container, homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();*/

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

       /* if (id == R.id.nav_personal) {
// Create fragment and give it an argument specifying the article it should show
            PersonalDetail newFragment = new PersonalDetail();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Personal Deatail");



            // Toast.makeText(getApplicationContext(),"home clicked",Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_fee) {

            FeeDetail newFragment = new FeeDetail();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Fee Detail");

            // Toast.makeText(getApplicationContext(),"Train Stations",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_circular) {

            Circular newFragment = new Circular();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Circular");
            // Toast.makeText(getApplicationContext(),"Train Schedule",Toast.LENGTH_LONG).show();
        }  else if (id == R.id.nav_library) {


            Library newFragment = new Library();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Library");



            //Toast.makeText(getApplicationContext(),"Profile",Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_attendence) {

            Attendence newFragment = new Attendence();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Attendance");
        }

        else if (id == R.id.nav_time) {

            TimeTable newFragment = new TimeTable();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Time Table");

        }


        else if(id == R.id.nav_report){

            ReportCardFragment newFragment = new ReportCardFragment();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Report Card");


        }

      *//*  else if (id == R.id.nav_report) {

            ReportCard newFragment = new ReportCard();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Report Card");*//*
        // Toast.makeText(getApplicationContext(),"logout",Toast.LENGTH_LONG).show();

          *//*  final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getResources().getString(R.string.logout_str))
                    .setCancelable(false)
                    .setPositiveButton(getResources().getString(R.string.yes_alert), new DialogInterface.OnClickListener() {
                        public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                            if (ServiceTools.isServiceRunning(getApplicationContext(), HajjLocationService.class)) {
                                stopService(new Intent(getApplicationContext(), HajjLocationService.class));
                            }
                            if (ServiceTools.isServiceRunning(getApplicationContext(), HajjIntentService.class)) {
                                stopService(new Intent(getApplicationContext(), HajjIntentService.class));
                            }
                            if (ylwlmanager != null) {

                                if (ServiceTools.isServiceRunning(getApplicationContext(), UartService.class)) {
                                    stopService(new Intent(getApplicationContext(), UartService.class));
                                }


                            }
                            logOut();
                        }
                    })
                    .setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                            dialog.cancel();
                        }
                    });
            final AlertDialog alert = builder.create();
            alert.show();*//*
        else if(id == R.id.nav_profile){

            PersonalProfile newFragment = new PersonalProfile();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Personal Profile");


        }else if(id == R.id.nav_notice) {

            NoticeBoard newFragment = new NoticeBoard();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Personal Profile");

        }


        else if(id == R.id.nav_book) {

            Book newFragment = new Book();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Personal Profile");

        }


        else if(id == R.id.nav_leave){

            LeaveFragment newFragment = new LeaveFragment();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            setTitle("Leave");


        }else if(id == R.id.nav_salary){

            SalaryFragment newFragment = new SalaryFragment();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container,newFragment);

            transaction.addToBackStack(null);

            transaction.commit();

            setTitle("Salary Detail");
        }else if (id == R.id.nav_subject){

            AttendenceFragment newFragment = new AttendenceFragment();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container,newFragment);

            transaction.addToBackStack(null);

            transaction.commit();

            setTitle("Mark Attendence");
        }


*/

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



