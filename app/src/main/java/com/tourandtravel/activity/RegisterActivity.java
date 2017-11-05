package com.tourandtravel.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.extect.appbase.BaseActivity;
import com.tourandtravel.R;
import com.tourandtravel.api.APIService;
import com.tourandtravel.api.ApiUtils;
import com.tourandtravel.model.CustomerRegisterModel;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by himanshu on 13-09-2017.
 */

public class RegisterActivity extends BaseActivity {



    private APIService mAPIService;
    private TextInputLayout nameTitle, emailTitle, passwordTitle, usernameTitle, phoneTitle;
    private EditText nameEdt, emailEdt, passEdt, phoneEdt, usernameEdt;

    private TextView signup,login;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        nameEdt = (EditText)findViewById(R.id.fullNameEt);
        emailEdt =(EditText)findViewById(R.id.emailEt);
        passEdt =(EditText)findViewById(R.id.passwordEt);
        phoneEdt =(EditText)findViewById(R.id.phoneNumberEt);
        usernameEdt=(EditText)findViewById(R.id.userNameEt);

        nameTitle =(TextInputLayout)findViewById(R.id.input_layout_fullname);
        passwordTitle =(TextInputLayout)findViewById(R.id.input_layout_password);
        emailTitle =(TextInputLayout)findViewById(R.id.input_layout_email);
        usernameTitle =(TextInputLayout)findViewById(R.id.input_layout_username);
        phoneTitle =(TextInputLayout)findViewById(R.id.input_layout_phoneNumber);

        mAPIService = ApiUtils.getAPIService();

        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.singnUp).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String name = nameEdt.getText().toString();
        String email = emailEdt.getText().toString();
        String phone = phoneEdt.getText().toString();
        String username = usernameEdt.getText().toString();
        String password = passEdt.getText().toString();

        super.onClick(view);
        switch (view.getId()) {
            case R.id.login:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
                break;

            case R.id.singnUp:


                if (username.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter username.", Toast.LENGTH_LONG).show();

                    return;

                }
                if (password.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter password.", Toast.LENGTH_LONG).show();

                    return;

                }
                if (name.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter name.", Toast.LENGTH_LONG).show();

                    return;

                }
                if (email.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter emailId.", Toast.LENGTH_LONG).show();

                    return;

                }
               if (!isValidEmaillId(email)) {
                    Toast.makeText(getApplicationContext(), "Please enter valid Email-Id", Toast.LENGTH_LONG).show();

                    return;
                }


                if (phone.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter your Mobile Number.", Toast.LENGTH_LONG).show();

                    return;

                }


                if (phone.trim().length() < 10) {
                    Toast.makeText(getApplicationContext(), "Please enter valid Mobile Number.", Toast.LENGTH_LONG).show();

                    return;


                }



                else{


                           sendRegister(emailEdt.getText().toString(),passEdt.getText().toString(),nameEdt.getText().toString(),usernameEdt.getText().toString(),phoneEdt.getText().toString());


                    }


                    break;
                }
        }




    private boolean isValidEmaillId(String email) {

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }


    public void sendRegister(String name, String email, String password, String phone, String username) {
        showProgressDialog();
        mAPIService.registerPost(name, password, email, username, phone).enqueue(new Callback<CustomerRegisterModel>() {
            @Override
            public void onResponse(Call<CustomerRegisterModel> call, Response<CustomerRegisterModel> response) {
                dismissProgressDialog();
                if (response.isSuccessful()) {
                    if(response.body().getStatus() == 1){
                        Toast.makeText(RegisterActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        finish();
                    }else{
                        Toast.makeText(RegisterActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<CustomerRegisterModel> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
                call.cancel();
                dismissProgressDialog();
            }
        });
    }




    @Override
    public void replaceView() {

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}