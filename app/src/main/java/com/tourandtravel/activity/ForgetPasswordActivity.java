package com.tourandtravel.activity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.extect.appbase.BaseActivity;
import com.tourandtravel.R;
import com.tourandtravel.api.APIService;
import com.tourandtravel.api.ApiUtils;

/**
 * Created by himanshu on 17-11-2017.
 */

public class ForgetPasswordActivity extends BaseActivity {


    private APIService mAPIService;
    private TextInputLayout  emailTitle;
    private EditText  emailEdt;

    private TextView send;
    private ProgressDialog progressDialog;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forget);

        emailEdt = (EditText) findViewById(R.id.emailEt);

        emailTitle = (TextInputLayout) findViewById(R.id.input_layout_email);


        mAPIService = ApiUtils.getAPIService();


        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(true);


            getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFFf'>Forget Password </font>"));


        }
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void replaceView() {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
