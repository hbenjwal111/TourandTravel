package com.tourandtravel.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tourandtravel.R;

import org.json.JSONArray;

/*import com.facebook.FacebookSdk;*/

/**
 * Created by himanshu on 08-09-2017.
 */

public class LoginActivity extends  AppCompatActivity {


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



  /*  Boolean isInternetPresent = false;*/


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);


        PrefManager prefManager = new PrefManager(getApplicationContext());

        // make first time launch TRUE
        prefManager.setFirstTimeLaunch(true);
      /*  FacebookSdk.sdkInitialize(getApplicationContext());*/

       /* checkConnection();*/


      /*  if(userType="Student"){


        }*/

      /*  cd = new ConnectionDetector(getApplicationContext());

        Check_Network();*/


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
}










