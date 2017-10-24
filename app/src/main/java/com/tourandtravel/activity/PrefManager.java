package com.tourandtravel.activity;

/**
 * Created by himanshu on 08-09-2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;


public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "splash_pref";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();

        boolean value = pref.getBoolean(IS_FIRST_TIME_LAUNCH, false);

    }

    public boolean isFirstTimeLaunch() {
        boolean value = pref.getBoolean(IS_FIRST_TIME_LAUNCH, false);

        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, false);
    }

}

