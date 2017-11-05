package com.tourandtravel.fragment;

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

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by himanshu on 31-10-2017.
 */

public class Commonfragment extends BaseFragment {



    private RecyclerView recyclerView;


    private FragmentManager fragmentManager;

    private Button mButton;
    private APIService mAPIService;

    String clus_description,clus_image,clus_title,clus_id;

    public Commonfragment() {


    }


    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        // Defines the xml file for the fragment

        View rootView = inflater.inflate(R.layout.fragment_common, parent, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view1);

         clus_description = getActivity().getIntent().getExtras().getString("clus_description");
         clus_image = getActivity().getIntent().getExtras().getString("clus_image");
         clus_title = getActivity().getIntent().getExtras().getString("clus_title");
         clus_id = getActivity().getIntent().getExtras().getString("clus_id");



        mAPIService = ApiUtils.getAPIService();





        mButton = (Button) rootView.findViewById(R.id.button_previous);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent commonActivity = new Intent(getActivity(),CommonBaseActivity.class);
                commonActivity.putExtra("flowType", CommonBaseActivity.HOTEL);
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
        showProgressDialog();

        mAPIService.getClusterDetail(Integer.parseInt(clus_id)).enqueue(new Callback<CommonList>() {
            @Override
            public void onResponse(Call<CommonList> call, Response<CommonList> response) {

               CommonList commonList = response.body();
                if(commonList.getStatus()==1){
                    List<CommonModel> modelList = commonList.getCommonModelList();
                    CommonAdapter commonAdapter = new CommonAdapter(getActivity(),modelList);

                    recyclerView.setAdapter(commonAdapter);
                    dismissProgressDialog();
                }else{
                    dismissProgressDialog();
                }

            }

            @Override
            public void onFailure(Call<CommonList> call, Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                dismissProgressDialog();


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
