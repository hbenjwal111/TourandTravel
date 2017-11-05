package com.tourandtravel.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.extect.appbase.BaseActivity;
import com.extect.appbase.BaseFragment;
import com.splunk.mint.Mint;
import com.tourandtravel.R;
import com.tourandtravel.fragment.BookFragment;
import com.tourandtravel.fragment.CommonHotelFragment;
import com.tourandtravel.fragment.Commonfragment;
import com.tourandtravel.fragment.HomeFragment;
import com.tourandtravel.fragment.ReviewBooking;
import com.tourandtravel.fragment.RoomTypeFragment;
import com.tourandtravel.fragment.TravellerDetails;

import listeners.IBackPressedListner;
import shared.BaseFlyContext;

/**
 * Created by Rana lucky on 12/16/2016.
 */

public class CommonBaseActivity extends BaseActivity {
    private  int flowStatus;String eventCategory;
    public static final int REQUEST_WRITE_STORAGE = 112;
    public static final int REQUEST_CAMERA = 113;
    public static final int REQUEST_PHONE = 114;


    public final static int CLUSTER = 0;

    public final static int CHECK_IN_NAV = 1;

    public final static int HOTEL = 2;

    public final static int ROOM = 3;

    public final static int BOOK = 4;

    public final static int REVIEW = 5;

    public final static int TRAVELLER = 6;





   /* protected void setupActionbar() {
        getmActionBar().show();
        getmActionBar().setTitle(getResources().getString(R.string.declare_intention_title));
        getmActionBar().setDisplayHomeAsUpEnabled(true);
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_base_activity_layout);
        Mint.initAndStartSession(this.getApplication(), "0172c1a8");

        mControlsView = findViewById(R.id.fullscreen_content_controls);

        Intent intent = getIntent();
        if (intent != null) {
            flowStatus = intent.getIntExtra("flowType",0);
            eventCategory = intent.getStringExtra("eventCategory");

        }

        hideSoftKeyboard();
        coordinatiorLayout = (CoordinatorLayout)findViewById(R.id.container);


        BaseFlyContext.getInstant().setActivity(this);




        switch (flowStatus)
        {
            case CLUSTER:
               /* BadrinathClusterFragment checkInFragment = new BadrinathClusterFragment();
                Bundle bundle = new Bundle();
                bundle.putString("eventCategory",eventCategory);
                checkInFragment.setArguments(bundle);
                replaceView(R.id.fullscreen_content_controls, checkInFragment, true, true);
                getmActionBar().setDisplayHomeAsUpEnabled(true);
*/
                getmActionBar().setTitle("Maestro Travel");
                replaceView(R.id.fullscreen_content_controls, new HomeFragment(),true,true);

                break;


            case CHECK_IN_NAV:

                getmActionBar().setTitle("About Cluster");
                getmActionBar().setDisplayHomeAsUpEnabled(true);
            replaceView(R.id.fullscreen_content_controls, new Commonfragment(),true,true);

                break;

            case HOTEL:

                getmActionBar().setTitle("Hotels");
                getmActionBar().setDisplayHomeAsUpEnabled(true);
                replaceView(R.id.fullscreen_content_controls, new CommonHotelFragment(),true,true);

                break;

            case ROOM:

                getmActionBar().setTitle("Choose Room");
                getmActionBar().setDisplayHomeAsUpEnabled(true);
                replaceView(R.id.fullscreen_content_controls, new RoomTypeFragment(),true,true);


              break;

            case BOOK:

                getmActionBar().setTitle("Book");
                getmActionBar().setDisplayHomeAsUpEnabled(true);
                replaceView(R.id.fullscreen_content_controls, new BookFragment(),true,true);




break;

            case REVIEW:

                getmActionBar().setTitle("Review Booking");
                getmActionBar().setDisplayHomeAsUpEnabled(true);
                replaceView(R.id.fullscreen_content_controls, new ReviewBooking(),true,true);




            break;

            case TRAVELLER:

                getmActionBar().setTitle("Traveller Details");
                getmActionBar().setDisplayHomeAsUpEnabled(true);
                replaceView(R.id.fullscreen_content_controls, new TravellerDetails(),true,true);




           /* case 99:
                *//**//*SelectAddOnsFragment selectAddon = new SelectAddOnsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("MobileNo",mobileNo);
                bundle.putString("reloadAmt",reloadAmt);
                selectAddon.setArguments(bundle);
                replaceView(R.id.fullscreen_content_controls,selectAddon,true,true);*//**//*
                break;*/
            default:
                // onBackPressed();
                break;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    int count = 0;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Toast.makeText(getActivity(), "called " + item.getItemId(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case android.R.id.home:
                android.app.FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    //fm.popBackStack();
                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
                else if(count>0)
                {
                    finish();
                }
                else {
                    onBackPressed();
                    count++;
                    //finish();
                }
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

                break;
           /* case R.id.miCompose:

                AddDuaFragment fragobj = new AddDuaFragment();
                Bundle bundle = new Bundle();
                bundle.putString("duaData", "");
                bundle.putInt("duaId",0);
                fragobj.setArguments(bundle);
                getBaseActivity().replaceView(R.id.fullscreen_content_controls, fragobj, true, false);



                break;*/

        }
        return super.onOptionsItemSelected(item);
    }
    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null)
        {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }


    @Override
    public void onResume() {

        // InsuredDataManager.getDataManager().sessionPulse(this, SettingServices.getInstance().getUserName(this));
        super.onResume();
    }
    @Override
    public void replaceView() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed() {

        hideKeyboard();
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        }
        else {
            int backStackCount = getSupportFragmentManager().getBackStackEntryCount();

            if(backStackCount > 0) {

                String tag = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
                BaseFragment baseFragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag(tag);
                if (baseFragment != null && baseFragment.isAllowBackStackNotify && baseFragment instanceof IBackPressedListner) {
                    ((IBackPressedListner)baseFragment).onBackPressNotify();
                }
                else {
                    super.onBackPressed();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void showAlertMissingInfo(String message) {
    }

    /* public void onBackPressed()
     {
         super.onBackPressed();
      *//*FragmentManager fm = getSupportFragmentManager();
     for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
         fm.popBackStack();
     }*//*
        *//*Intent intent=new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("MESSAGE","");
        setResult(2,intent);
        finish();*//*
        //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }*/
    public void reLounchApp(String errorMsg){/*

        android.app.AlertDialog alert = new android.app.AlertDialog.Builder(BaseFlyContext.getInstant().getActivity(), R.style.AppCompatAlertDialogStyle)
                .setTitle("Message")
                .setMessage(errorMsg)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent i = new Intent(ePosMainActivity, EPosLoginActivity.class);
                        i.addCategory(Intent.CATEGORY_LAUNCHER);
                        i.putExtra("flag","1");
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                        finish();
                        dialog.dismiss();
                    }
                }).show();
        alert.setCancelable(false);
        alert.setCanceledOnTouchOutside(true);
    */}


}


