package com.tourandtravel.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.extect.appbase.BaseActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.tourandtravel.R;
import com.tourandtravel.api.APIService;
import com.tourandtravel.api.ApiUtils;
import com.tourandtravel.api.AppPreferences;
import com.tourandtravel.model.CustomerLoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*import com.facebook.FacebookSdk;*/

/**
 * Created by himanshu on 08-09-2017.
 */

public class LoginActivity extends BaseActivity {


    private EditText emailEdt, passEdt;
    private APIService mAPIService;

    private TextView submit_btn,signUpTv;
    public Context context;
    public LoginButton loginButton;

    CallbackManager callbackManager;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mAPIService = ApiUtils.getAPIService();

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);

        loginButton = (LoginButton)findViewById(R.id.fbbutton);

        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                LoginManager.getInstance().logOut();
            }

            @Override
            public void onCancel() {

                showToast("Cancelled.");
                LoginManager.getInstance().logOut();
            }

            @Override
            public void onError(FacebookException error) {

                showToast(error+"");
                LoginManager.getInstance().logOut();

            }
        });



        PrefManager prefManager = new PrefManager(getApplicationContext());

        // make first time launch TRUE
        prefManager.setFirstTimeLaunch(true);


        context = getBaseContext();

        findViewById(R.id.signUpTv).setOnClickListener(this);
        findViewById(R.id.loginBtn).setOnClickListener(this);

        emailEdt = (EditText) findViewById(R.id.userNameEt);
        passEdt = (EditText) findViewById(R.id.passwordEt);






    }

    @Override
    public void onClick(View view) {
        String user_name = emailEdt.getText().toString();
        String password = passEdt.getText().toString();

        super.onClick(view);
        switch (view.getId()) {
            case R.id.signUpTv:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
                break;

            case R.id.loginBtn:



                if(user_name.trim().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please enter username.", Toast.LENGTH_LONG) .show();

                    return;

                }
                if(password.trim().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please enter password.", Toast.LENGTH_LONG) .show();

                    return;

                }else{

                    sendLogin(emailEdt.getText().toString(),passEdt.getText().toString(), AppPreferences.getPrefs(LoginActivity.this).getStringValue(AppPreferences.FIREBASE_ID));

                }




                break;
        }
    }

    public void sendLogin(String user_name, String password,String token) {
        showProgressDialog();
        mAPIService.loginPost(user_name, password,token).enqueue(new Callback<CustomerLoginModel>() {
            @Override
            public void onResponse(Call<CustomerLoginModel> call, Response<CustomerLoginModel> response) {
                dismissProgressDialog();
                if (response.isSuccessful()) {
                    if(response.body().getStatus() == 1){
                        Toast.makeText(LoginActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        AppPreferences.getPrefs(LoginActivity.this).setBooleanValue(AppPreferences.IS_LOGIN,true);
                        AppPreferences.getPrefs(LoginActivity.this).setStringValue(AppPreferences.USER_ID,response.body().getUserId());
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<CustomerLoginModel> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
                call.cancel();
                dismissProgressDialog();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }



    @Override
    public void replaceView() {

    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}





