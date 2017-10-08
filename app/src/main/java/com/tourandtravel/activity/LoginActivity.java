package com.tourandtravel.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.extect.appbase.BaseActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.tourandtravel.R;

import org.json.JSONArray;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*import com.facebook.FacebookSdk;*/

/**
 * Created by himanshu on 08-09-2017.
 */

public class LoginActivity extends BaseActivity {


    private String name, password;

    public String userType;

    public String student, employee;

   /* public String userType;*/

    private ProgressDialog pDialog;

  /*  ConnectionDetector cd;*/

    private TextView submit_btn,signUpTv;
    private EditText user, pwd;
    private String URL_NEW_PREDICTION;
    public Context context;
    public static String response, st_status, stu_code;
    //// public int abc;
    private JSONArray user_detail;

    public LoginButton loginButton;

    CallbackManager callbackManager;



  /*  Boolean isInternetPresent = false;*/


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);

        loginButton = (LoginButton)findViewById(R.id.fbbutton);

        callbackManager = CallbackManager.Factory.create();

        generateHashKey();


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                showToast(new Gson().toJson(loginResult).toString());


            }

            @Override
            public void onCancel() {

                showToast("Cancelled.");

            }

            @Override
            public void onError(FacebookException error) {

                showToast(error+"");


            }
        });



        PrefManager prefManager = new PrefManager(getApplicationContext());

        // make first time launch TRUE
        prefManager.setFirstTimeLaunch(true);


        context = getBaseContext();
        user = (EditText) findViewById(R.id.userNameEt);


        // user.setText("0161BCM065");
        pwd = (EditText) findViewById(R.id.passwordEt);


        // pwd.setText("star");
        submit_btn = (TextView) findViewById(R.id.loginBtn);

        signUpTv = (TextView)findViewById(R.id.signUpTv);


        signUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);

                 startActivity(intent);
            }
        });




        submit_btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);


            }

          /*  pDialog.dismiss();*/


        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    private void generateHashKey() {
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.tourndtrvel",
                    PackageManager.GET_SIGNATURES);

            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

    }

    @Override
    public void replaceView() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}










