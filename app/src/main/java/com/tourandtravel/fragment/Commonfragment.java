package com.tourandtravel.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.extect.appbase.BaseFragment;
import com.tourandtravel.R;
import com.tourandtravel.activity.CommonBaseActivity;
import com.tourandtravel.adapter.CommonAdapter;
import com.tourandtravel.api.APIService;
import com.tourandtravel.api.ApiUtils;
import com.tourandtravel.model.CommonList;
import com.tourandtravel.model.CommonModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utils.Utils;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by himanshu on 31-10-2017.
 */

public class Commonfragment extends BaseFragment {



    private RecyclerView recyclerView;


    private FragmentManager fragmentManager;

    private Button mButton;
    private APIService mAPIService;


    List<CommonModel> modelList;




    String hotel_image,name,district,hotel_id;

    ProgressDialog progressDialog;

    String clus_description,clus_image,clus_title,clus_id;


    public Commonfragment() {

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        // Defines the xml file for the fragment

        View rootView = inflater.inflate(R.layout.fragment_common, parent, false);

        clus_description = getActivity().getIntent().getExtras().getString("clus_description");
        clus_image = getActivity().getIntent().getExtras().getString("clus_image");
        clus_title = getActivity().getIntent().getExtras().getString("clus_title");
        clus_id = getActivity().getIntent().getExtras().getString("clus_id");


        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view1);



       /* name=getActivity().getIntent().getExtras().getString("name");
        about=getActivity().getIntent().getExtras().getString("about");
        image=getActivity().getIntent().getExtras().getString("image");
        activity_id=getActivity().getIntent().getExtras().getString("activity_id");
*/



        mAPIService = ApiUtils.getAPIService();





        mButton = (Button) rootView.findViewById(R.id.button_previous);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {









                Intent commonActivity = new Intent(getActivity(),CommonBaseActivity.class);

                commonActivity.putExtra("flowType", CommonBaseActivity.HOTEL);


                commonActivity.putExtra("clus_id", clus_id);






                startActivity(commonActivity);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });


        setHasOptionsMenu(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        getClusterDetail();


        return rootView;



    }


    private void getClusterDetail(){
        if (Utils.isNetworkConnected(getActivity(), true, R.style.AppCompatAlertDialogStyle)) {
            progressDialog = new ProgressDialog(getActivity(), R.style.AppCompatAlertDialogStyle);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        mAPIService.getClusterDetail(Integer.parseInt(clus_id)).enqueue(new Callback<CommonList>() {
            @Override
            public void onResponse(Call<CommonList> call, Response<CommonList> response) {

                CommonList commonList = response.body();
                if(commonList.getStatus()==1){
                   modelList = commonList.getCommonModelList();
                    CommonAdapter commonAdapter = new CommonAdapter(getActivity(),modelList);

                    recyclerView.setAdapter(commonAdapter);
                   progressDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<CommonList> call, Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();


            }
        });



    }





    @Override
    public void setTAG(String TAG) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

    }
}
