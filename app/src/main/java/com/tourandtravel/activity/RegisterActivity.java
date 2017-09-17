package com.tourandtravel.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.tourandtravel.R;

/**
 * Created by himanshu on 13-09-2017.
 */

public class RegisterActivity extends AppCompatActivity {


      private EditText fullName,userName,userPass;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);


        PrefManager prefManager = new PrefManager(getApplicationContext());

        // make first time launch TRUE
        prefManager.setFirstTimeLaunch(true);

        EditText fullName = (EditText)findViewById(R.id.fullNameEt);



      /*  FacebookSdk.sdkInitialize(getApplicationContext());*/

       /* checkConnection();*/


      /*  if(userType="Student"){


        }*/

      /*  cd = new ConnectionDetector(getApplicationContext());

        Check_Network();*/


    }
}
