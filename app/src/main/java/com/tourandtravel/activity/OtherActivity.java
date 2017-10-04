package com.tourandtravel.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.tourandtravel.DrawerLocker;
import com.tourandtravel.R;

/**
 * Created by himanshu on 05-10-2017.
 */


public class OtherActivity extends AppCompatActivity implements DrawerLocker {


      public DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // test commit by Lucky
    }

    public void setDrawerLocked(boolean enabled) {
        if (enabled) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        } else {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }

    }

}