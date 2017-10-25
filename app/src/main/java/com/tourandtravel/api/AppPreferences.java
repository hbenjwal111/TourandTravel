package com.tourandtravel.api;

import android.content.Context;
import android.content.SharedPreferences;


public class AppPreferences {
    private static final String SHARED_PREFERENCE_NAME = "TEREX_APP";
    public static final String IS_LOGIN = "IS_LOGIN";
    public static final String IS_FB_LOGIN = "IS_FB_LOGIN";
    public static final String USER_ID = "USER_ID";
    public static final String USER_NAME = "USER_NAME";
    public static final String FIREBASE_ID = "FIREBASE_ID";


    public SharedPreferences mPrefs;
    private Context context;

    public AppPreferences(Context context) {
        this.context = context;
        mPrefs = context.getSharedPreferences(SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE);
    }

    public static AppPreferences getPrefs(Context context) {
        return new AppPreferences(context);

    }

    public String getStringValue(String Key) {
        return mPrefs.getString(Key, "");
    }

    public boolean getBooleanValue(String Key) {
        return mPrefs.getBoolean(Key, false);
    }


    public void setStringValue(String Key, String value) {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(Key, value);
        editor.commit();
    }

    public void setBooleanValue(String Key, boolean value) {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putBoolean(Key, value);
        editor.commit();
    }

    public void clearAppPreferences(){
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.clear();
        editor.commit();
    }
}
